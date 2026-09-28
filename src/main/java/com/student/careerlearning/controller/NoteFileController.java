package com.student.careerlearning.controller;

import com.student.careerlearning.model.NoteFile;
import com.student.careerlearning.repository.NoteFileRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes-files")
@CrossOrigin
public class NoteFileController {

    private final NoteFileRepository noteFileRepository;

    public NoteFileController(NoteFileRepository noteFileRepository) {
        this.noteFileRepository = noteFileRepository;
    }

    @GetMapping("/{username}")
    public List<NoteFile> getStudentNotes(@PathVariable String username) {
        return noteFileRepository.findByUsernameOrderByCreatedAtDesc(username);
    }

    @GetMapping("/{username}/favorites")
    public List<NoteFile> getStudentFavorites(@PathVariable String username) {
        return noteFileRepository
                .findByUsernameAndFavoriteTrueOrderByCreatedAtDesc(username);
    }

    @PostMapping
    public NoteFile saveNote(@RequestBody NoteFile noteFile) {
        return noteFileRepository.save(noteFile);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteFileRepository.deleteById(id);
    }
}