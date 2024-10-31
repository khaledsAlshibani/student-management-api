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

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/subject")
    public ResponseEntity<Grade> getGradeBySubject(@RequestBody Subject subject) {
        Optional<Grade> grade = gradeService.getGradeBySubject(subject);
        return grade.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<Grade> createGrade(@RequestBody Grade grade) {
        Grade createdGrade = gradeService.createGrade(grade);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGrade);
    }

    @PutMapping("/subject")
    public ResponseEntity<Grade> updateGrade(@RequestBody Subject subject, @RequestBody Grade updatedGrade) {
        Optional<Grade> grade = gradeService.updateGrade(subject, updatedGrade);
        return grade.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/subject")
    public ResponseEntity<Void> deleteGrade(@RequestBody Subject subject) {
        if (gradeService.deleteGrade(subject)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
