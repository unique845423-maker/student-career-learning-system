
package com.student.careerlearning.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "note_files")
public class NoteFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Username of the logged-in student.
     * This ensures every student has their own data.
     */
    private String username;

    /*
     * Note/File title
     */
    private String title;

    /*
     * Note content or description
     */
    @Column(columnDefinition = "TEXT")
    private String description;

    /*
     * Category such as:
     * Study, Assignment, Project, Exam, Personal etc.
     */
    private String category;

    /*
     * Original uploaded file name
     */
    private String fileName;

    /*
     * MIME type of uploaded file
     * Example:
     * application/pdf
     * image/png
     * application/msword
     */
    private String fileType;

    /*
     * File size in bytes
     */
    private Long fileSize;

    /*
     * Actual uploaded file data.
     * This will allow PDFs, DOC/DOCX, PPT/PPTX,
     * images and other allowed study files
     * to be stored in MySQL.
     */
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] fileData;

    /*
     * Favorite / pinned item
     */
    private boolean favorite;

    /*
     * Date and time when item was created
     */
    private LocalDateTime createdAt;


    // ==========================================
    // CONSTRUCTOR
    // ==========================================

    public NoteFile() {
    }


    // ==========================================
    // ID
    // ==========================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    // ==========================================
    // USERNAME
    // ==========================================

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    // ==========================================
    // TITLE
    // ==========================================

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    // ==========================================
    // DESCRIPTION / NOTE CONTENT
    // ==========================================

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    // ==========================================
    // CATEGORY
    // ==========================================

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    // ==========================================
    // FILE NAME
    // ==========================================

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    // ==========================================
    // FILE TYPE
    // ==========================================

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }


    // ==========================================
    // FILE SIZE
    // ==========================================

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }


    // ==========================================
    // FILE DATA
    // ==========================================

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }


    // ==========================================
    // FAVORITE
    // ==========================================

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }


    // ==========================================
    // CREATED AT
    // ==========================================

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
