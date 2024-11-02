package com.kss.studentmanagementapi.controller;

import com.kss.studentmanagementapi.model.Subject;
import com.kss.studentmanagementapi.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Subject entities.
 * Provides endpoints for CRUD operations on subjects.
 */
@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    /** Service for handling subject-related operations. */
    private final SubjectService subjectService;

    /**
     * Constructor to inject SubjectService.
     *
     * @param subjectService the subject service to be injected
     */
    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    /**
     * Retrieves all subjects.
     *
     * @return a list of all subjects
     */
    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    /**
     * Retrieves a subject by its unique ID.
     *
     * @param id the unique identifier of the subject
     * @return ResponseEntity containing the subject if found, otherwise 404 NOT FOUND
     */
    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
        Optional<Subject> subject = subjectService.getSubjectById(id);
        return subject.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    /**
     * Creates a new subject.
     *
     * @param subject the subject to be created
     * @return ResponseEntity containing the created subject with 201 CREATED status
     */
    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject createdSubject = subjectService.createSubject(subject);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubject);
    }

    /**
     * Updates an existing subject's details based on its unique ID.
     *
     * @param id the unique identifier of the subject to update
     * @param updatedSubject the subject containing updated information
     * @return ResponseEntity containing the updated subject if found, otherwise 404 NOT FOUND
     */
    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject updatedSubject) {
        Optional<Subject> subject = subjectService.updateSubject(id, updatedSubject);
        return subject.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    /**
     * Deletes a subject by its unique ID.
     *
     * @param id the unique identifier of the subject to delete
     * @return ResponseEntity with 204 NO CONTENT if deletion is successful, otherwise 404 NOT FOUND
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        if (subjectService.deleteSubject(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
