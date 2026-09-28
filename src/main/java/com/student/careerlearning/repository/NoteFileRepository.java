package com.student.careerlearning.repository;

import com.student.careerlearning.model.NoteFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteFileRepository extends JpaRepository<NoteFile, Long> {

    List<NoteFile> findByUsernameOrderByCreatedAtDesc(String username);

    List<NoteFile> findByUsernameAndFavoriteTrueOrderByCreatedAtDesc(String username);
}
