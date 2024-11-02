package com.kss.studentmanagementapi.service;

import com.kss.studentmanagementapi.model.Grade;
import com.kss.studentmanagementapi.model.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Grade entities.
 * Provides methods for CRUD operations on grades,
 * allowing for grade retrieval, creation, updating, and deletion.
 */
@Service
public class GradeService {

    /** List of grades to store grade data in-memory. */
    private List<Grade> grades = new ArrayList<>();

    /**
     * Default constructor initializing GradeService with sample data for demonstration purposes.
     */
    public GradeService() {
        // Sample data for demonstration purposes
        Subject math = new Subject(1L, "Math", null);  // Placeholder for Teacher
        grades.add(new Grade(math, 85.0));
    }

    /**
     * Retrieves all grades.
     *
     * @return a list of all grades
     */
    public List<Grade> getAllGrades() {
        return grades;
    }

    /**
     * Retrieves a grade by its associated subject.
     *
     * @param subject the subject for which the grade is retrieved
     * @return an Optional containing the grade if found, otherwise empty
     */
    public Optional<Grade> getGradeBySubject(Subject subject) {
        return grades.stream()
                .filter(grade -> grade.getSubject().equals(subject))
                .findFirst();
    }

    /**
     * Creates and stores a new grade.
     *
     * @param grade the grade to be created and stored
     * @return the created grade
     */
    public Grade createGrade(Grade grade) {
        grades.add(grade);
        return grade;
    }

    /**
     * Updates an existing grade's score based on the provided subject.
     *
     * @param subject the subject for which the grade is updated
     * @param updatedGrade the grade containing updated information
     * @return an Optional containing the updated grade if found, otherwise empty
     */
    public Optional<Grade> updateGrade(Subject subject, Grade updatedGrade) {
        return getGradeBySubject(subject).map(grade -> {
            grade.setScore(updatedGrade.getScore());
            return grade;
        });
    }

    /**
     * Deletes a grade associated with the specified subject.
     *
     * @param subject the subject whose associated grade is to be deleted
     * @return true if the grade was deleted, otherwise false
     */
    public boolean deleteGrade(Subject subject) {
        return grades.removeIf(grade -> grade.getSubject().equals(subject));
    }
}