package com.kss.studentmanagementapi.controller;

import com.kss.studentmanagementapi.model.Grade;
import com.kss.studentmanagementapi.model.Subject;
import com.kss.studentmanagementapi.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Grade entities.
 * Provides endpoints for CRUD operations on grades.
 */
@RestController
@RequestMapping("/api/grades")
public class GradeController {

    /** Service for handling grade-related operations. */
    private final GradeService gradeService;

    /**
     * Constructor to inject GradeService.
     *
     * @param gradeService the grade service to be injected
     */
    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    /**
     * Retrieves all grades.
     *
     * @return a list of all grades
     */
    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    /**
     * Retrieves a grade by its associated subject.
     *
     * @param subject the subject for which the grade is retrieved
     * @return ResponseEntity containing the grade if found, otherwise 404 NOT FOUND
     */
    @GetMapping("/subject")
    public ResponseEntity<Grade> getGradeBySubject(@RequestBody Subject subject) {
        Optional<Grade> grade = gradeService.getGradeBySubject(subject);
        return grade.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    /**
     * Creates a new grade.
     *
     * @param grade the grade to be created
     * @return ResponseEntity containing the created grade with 201 CREATED status
     */
    @PostMapping
    public ResponseEntity<Grade> createGrade(@RequestBody Grade grade) {
        Grade createdGrade = gradeService.createGrade(grade);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGrade);
    }

    /**
     * Updates an existing grade's score based on the provided subject.
     *
     * @param subject the subject for which the grade is updated
     * @param updatedGrade the grade containing updated information
     * @return ResponseEntity containing the updated grade if found, otherwise 404 NOT FOUND
     */
    @PutMapping("/subject")
    public ResponseEntity<Grade> updateGrade(@RequestBody Subject subject, @RequestBody Grade updatedGrade) {
        Optional<Grade> grade = gradeService.updateGrade(subject, updatedGrade);
        return grade.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    /**
     * Deletes a grade associated with the specified subject.
     *
     * @param subject the subject whose associated grade is to be deleted
     * @return ResponseEntity with 204 NO CONTENT if deletion is successful, otherwise 404 NOT FOUND
     */
    @DeleteMapping("/subject")
    public ResponseEntity<Void> deleteGrade(@RequestBody Subject subject) {
        if (gradeService.deleteGrade(subject)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
