package com.kss.studentmanagementapi.controller;

import com.kss.studentmanagementapi.model.Student;
import com.kss.studentmanagementapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Student entities.
 * Provides endpoints for CRUD operations on students.
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {

    /** Service for handling student-related operations. */
    private final StudentService studentService;

    /**
     * Constructor to inject StudentService.
     *
     * @param studentService the student service to be injected
     */
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Retrieves all students.
     *
     * @return a list of all students
     */
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    /**
     * Retrieves a student by their unique ID.
     *
     * @param id the unique identifier of the student
     * @return ResponseEntity containing the student if found, otherwise 404 NOT FOUND
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    /**
     * Creates a new student.
     *
     * @param student the student to be created
     * @return ResponseEntity containing the created student with 201 CREATED status, or 500 INTERNAL SERVER ERROR if creation fails
     */
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            Student createdStudent = studentService.createStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * Updates an existing student's details based on their unique ID.
     *
     * @param id the unique identifier of the student to update
     * @param updatedStudent the student containing updated information
     * @return ResponseEntity containing the updated student if found, otherwise 404 NOT FOUND
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Optional<Student> student = studentService.updateStudent(id, updatedStudent);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    /**
     * Deletes a student by their unique ID.
     *
     * @param id the unique identifier of the student to delete
     * @return ResponseEntity with 204 NO CONTENT if deletion is successful, otherwise 404 NOT FOUND
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (studentService.deleteStudent(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
