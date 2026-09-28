package com.student.careerlearning.controller;

import com.student.careerlearning.model.NoteFile;
import com.student.careerlearning.repository.NoteFileRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/notes-files")
@CrossOrigin
public class NoteFileController {

    private final NoteFileRepository noteFileRepository;

    public NoteFileController(NoteFileRepository noteFileRepository) {
        this.noteFileRepository = noteFileRepository;
    }

    @GetMapping
    public List<NoteFile> getStudentNotes(HttpSession session) {

        String username = getLoggedInUsername(session);

        return noteFileRepository
                .findByUsernameOrderByCreatedAtDesc(username);
    }

    @GetMapping("/favorites")
    public List<NoteFile> getStudentFavorites(HttpSession session) {

        String username = getLoggedInUsername(session);

        return noteFileRepository
                .findByUsernameAndFavoriteTrueOrderByCreatedAtDesc(username);
    }

    @PostMapping
    public NoteFile saveNote(
            @RequestBody NoteFile noteFile,
            HttpSession session) {

        String username = getLoggedInUsername(session);

        noteFile.setUsername(username);
        noteFile.setFileData(null);
        noteFile.setFileName(null);
        noteFile.setFileType(null);
        noteFile.setFileSize(null);
        noteFile.setCreatedAt(LocalDateTime.now());

        return noteFileRepository.save(noteFile);
    }

    @PostMapping("/upload")
    public NoteFile uploadFile(
            @RequestParam("title") String title,
            @RequestParam("category") String category,
            @RequestParam("file") MultipartFile file,
            HttpSession session) throws IOException {

        String username = getLoggedInUsername(session);

        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        if (file.getSize() > 20L * 1024L * 1024L) {
            throw new IllegalArgumentException(
                    "File size must be 20 MB or less"
            );
        }

        NoteFile noteFile = new NoteFile();

        noteFile.setUsername(username);
        noteFile.setTitle(title);
        noteFile.setCategory(category);
        noteFile.setFileName(file.getOriginalFilename());
        noteFile.setFileType(file.getContentType());
        noteFile.setFileSize(file.getSize());
        noteFile.setFileData(file.getBytes());
        noteFile.setFavorite(false);
        noteFile.setCreatedAt(LocalDateTime.now());

        return noteFileRepository.save(noteFile);
    }

    @PutMapping("/{id}/favorite")
    public NoteFile toggleFavorite(
            @PathVariable Long id,
            @RequestParam boolean favorite,
            HttpSession session) {

        String username = getLoggedInUsername(session);

        NoteFile noteFile = noteFileRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Note/File not found")
                );

        checkOwnership(noteFile, username);

        noteFile.setFavorite(favorite);

        return noteFileRepository.save(noteFile);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNote(
            @PathVariable Long id,
            HttpSession session) {

        String username = getLoggedInUsername(session);

        NoteFile noteFile = noteFileRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Note/File not found")
                );

        checkOwnership(noteFile, username);

        noteFileRepository.delete(noteFile);
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<byte[]> downloadFile(
            @PathVariable Long id,
            HttpSession session) {

        String username = getLoggedInUsername(session);

        NoteFile noteFile = noteFileRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Note/File not found")
                );

        checkOwnership(noteFile, username);

        if (noteFile.getFileData() == null) {
            return ResponseEntity.notFound().build();
        }

        String contentType = noteFile.getFileType();

        if (contentType == null || contentType.isBlank()) {
            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }

        String fileName = noteFile.getFileName();

        if (fileName == null || fileName.isBlank()) {
            fileName = "study-file";
        }

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(
                MediaType.parseMediaType(contentType)
        );

        headers.setContentDisposition(
                ContentDisposition.attachment()
                        .filename(fileName)
                        .build()
        );

        return new ResponseEntity<>(
                noteFile.getFileData(),
                headers,
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}/view")
    public ResponseEntity<byte[]> viewFile(
            @PathVariable Long id,
            HttpSession session) {

        String username = getLoggedInUsername(session);

        NoteFile noteFile = noteFileRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Note/File not found")
                );

        checkOwnership(noteFile, username);

        if (noteFile.getFileData() == null) {
            return ResponseEntity.notFound().build();
        }

        String contentType = noteFile.getFileType();

        if (contentType == null || contentType.isBlank()) {
            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(
                MediaType.parseMediaType(contentType)
        );

        return new ResponseEntity<>(
                noteFile.getFileData(),
                headers,
                HttpStatus.OK
        );
    }

    private String getLoggedInUsername(HttpSession session) {

        Object username =
                session.getAttribute("loggedInUsername");

        if (username == null) {
            throw new RuntimeException(
                    "Student is not logged in"
            );
        }

        return username.toString();
    }

    private void checkOwnership(
            NoteFile noteFile,
            String username) {

        if (!username.equals(noteFile.getUsername())) {

            throw new RuntimeException(
                    "Access denied"
            );
        }
    }
}