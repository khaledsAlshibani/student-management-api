package com.kss.studentmanagementapi.service;

import com.kss.studentmanagementapi.model.Grade;
import com.kss.studentmanagementapi.model.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    private List<Grade> grades = new ArrayList<>();

    public GradeService() {
        // Sample data for demonstration purposes
        Subject math = new Subject(1L, "Math", null);  // Placeholder for Teacher
        grades.add(new Grade(math, 85.0));
    }

    public List<Grade> getAllGrades() {
        return grades;
    }

    public Optional<Grade> getGradeBySubject(Subject subject) {
        return grades.stream()
                .filter(grade -> grade.getSubject().equals(subject))
                .findFirst();
    }

    public Grade createGrade(Grade grade) {
        grades.add(grade);
        return grade;
    }

    public Optional<Grade> updateGrade(Subject subject, Grade updatedGrade) {
        return getGradeBySubject(subject).map(grade -> {
            grade.setScore(updatedGrade.getScore());
            return grade;
        });
    }

    public boolean deleteGrade(Subject subject) {
        return grades.removeIf(grade -> grade.getSubject().equals(subject));
    }
}
