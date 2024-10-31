package com.kss.studentmanagementapi.service;

import com.kss.studentmanagementapi.model.Student;
import com.kss.studentmanagementapi.model.Grade;
import com.kss.studentmanagementapi.model.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    private Long nextId = 1L;

    public StudentService() {
        Subject math = new Subject(1L, "Math", null);
        Subject physics = new Subject(2L, "Physics", null);

        List<Grade> grades = List.of(new Grade(math, 85.0), new Grade(physics, 90.0));

        students.add(new Student(nextId++, "Khaled", new Date(), "Taiz", "male", "enrolled", grades, "http://example.com/photos/khaled.jpg"));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Optional<Student> getStudentById(Long id) {
        return students.stream()
                .filter(student -> student.getStudentId().equals(id))
                .findFirst();
    }

    public Student createStudent(Student student) {
        student.setStudentId(nextId++);
        students.add(student);
        return student;
    }

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

    public boolean deleteStudent(Long id) {
        return students.removeIf(student -> student.getStudentId().equals(id));
    }
}
