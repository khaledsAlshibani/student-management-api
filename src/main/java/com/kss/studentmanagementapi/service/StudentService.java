package com.kss.studentmanagementapi.service;

import com.kss.studentmanagementapi.model.Student;
import com.kss.studentmanagementapi.model.Grade;
import com.kss.studentmanagementapi.model.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Student entities.
 * Provides methods for CRUD operations on students, allowing for
 * student retrieval, creation, updating, and deletion.
 */
@Service
public class StudentService {

    /** List of students stored in-memory. */
    private final List<Student> students = new ArrayList<>();

    /** Counter for generating unique student IDs. */
    private Long nextId = 1L;

    /**
     * Default constructor initializing StudentService with sample data for demonstration purposes.
     */
    public StudentService() {
        Subject math = new Subject(1L, "Math", null);
        Subject physics = new Subject(2L, "Physics", null);

        List<Grade> grades = List.of(new Grade(math, 85.0), new Grade(physics, 90.0));

        students.add(new Student(nextId++, "Khaled", LocalDate.now(), "Taiz", "male", "enrolled", grades, "http://example.com/photos/khaled.jpg"));
    }

    /**
     * Retrieves all students.
     *
     * @return a list of all students
     */
    public List<Student> getAllStudents() {
        return students;
    }

    /**
     * Retrieves a student by their unique ID.
     *
     * @param id the unique identifier of the student
     * @return an Optional containing the student if found, otherwise empty
     */
    public Optional<Student> getStudentById(Long id) {
        return students.stream()
                .filter(student -> student.getStudentId().equals(id))
                .findFirst();
    }

    /**
     * Creates a new student and adds them to the list.
     *
     * @param student the student to be created
     * @return the created student with an assigned ID
     */
    public Student createStudent(Student student) {
        student.setStudentId(nextId++);
        students.add(student);
        return student;
    }

    /**
     * Updates an existing student's details based on their unique ID.
     *
     * @param id the unique identifier of the student to update
     * @param updatedStudent the student containing updated information
     * @return an Optional containing the updated student if found, otherwise empty
     */
    public Optional<Student> updateStudent(Long id, Student updatedStudent) {
        return getStudentById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setBirthDate(updatedStudent.getBirthDate());
            student.setBirthPlace(updatedStudent.getBirthPlace());
            student.setGender(updatedStudent.getGender());
            student.setEnrollmentStatus(updatedStudent.getEnrollmentStatus());
            student.setGrades(updatedStudent.getGrades());
            student.setPhotoUrl(updatedStudent.getPhotoUrl());
            return student;
        });
    }

    /**
     * Deletes a student by their unique ID.
     *
     * @param id the unique identifier of the student to delete
     * @return true if the student was deleted, otherwise false
     */
    public boolean deleteStudent(Long id) {
        return students.removeIf(student -> student.getStudentId().equals(id));
    }
}
