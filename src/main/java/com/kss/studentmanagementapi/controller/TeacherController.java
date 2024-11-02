package com.kss.studentmanagementapi.controller;

import com.kss.studentmanagementapi.model.Subject;
import com.kss.studentmanagementapi.model.Teacher;
import com.kss.studentmanagementapi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Teacher entities.
 * Provides endpoints for CRUD operations on teachers and for adding subjects to teachers.
 */
@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    /** Service for handling teacher-related operations. */
    private final TeacherService teacherService;

    /**
     * Constructor to inject TeacherService.
     *
     * @param teacherService the teacher service to be injected
     */
    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    /**
     * Retrieves all teachers.
     *
     * @return a list of all teachers
     */
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    /**
     * Retrieves a teacher by their unique ID.
     *
     * @param id the unique identifier of the teacher
     * @return ResponseEntity containing the teacher if found, otherwise 404 NOT FOUND
     */
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        return teacher.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    /**
     * Creates a new teacher.
     *
     * @param teacher the teacher to be created
     * @return ResponseEntity containing the created teacher with 201 CREATED status
     */
    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = teacherService.createTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeacher);
    }

    /**
     * Updates an existing teacher's details based on their unique ID.
     *
     * @param id the unique identifier of the teacher to update
     * @param updatedTeacher the teacher containing updated information
     * @return ResponseEntity containing the updated teacher if found, otherwise 404 NOT FOUND
     */
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher updatedTeacher) {
        Optional<Teacher> teacher = teacherService.updateTeacher(id, updatedTeacher);
        return teacher.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    /**
     * Adds subjects to an existing teacher's list of subjects.
     *
     * @param id the unique identifier of the teacher to whom subjects are added
     * @param subjects the list of subjects to add to the teacher's subjects
     * @return ResponseEntity containing the updated teacher if found, otherwise 404 NOT FOUND
     */
    @PutMapping("/{id}/subjects")
    public ResponseEntity<Teacher> addSubjectsToTeacher(@PathVariable Long id, @RequestBody List<Subject> subjects) {
        Optional<Teacher> teacher = teacherService.addSubjectsToTeacher(id, subjects);
        return teacher.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    /**
     * Deletes a teacher by their unique ID.
     *
     * @param id the unique identifier of the teacher to delete
     * @return ResponseEntity with 204 NO CONTENT if deletion is successful, otherwise 404 NOT FOUND
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        if (teacherService.deleteTeacher(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
