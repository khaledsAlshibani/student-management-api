package com.kss.studentmanagementapi.service;

import com.kss.studentmanagementapi.model.Subject;
import com.kss.studentmanagementapi.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private List<Subject> subjects = new ArrayList<>();
    private Long nextId = 1L;

    public SubjectService() {
        // Sample data for demonstration
        Teacher teacher = new Teacher(1L, "Dr. Smith", List.of("Math", "Physics"));
        subjects.add(new Subject(nextId++, "Math", teacher));
        subjects.add(new Subject(nextId++, "Physics", teacher));
    }

    public List<Subject> getAllSubjects() {
        return subjects;
    }

    public Optional<Subject> getSubjectById(Long id) {
        return subjects.stream().filter(subject -> subject.getSubjectId().equals(id)).findFirst();
    }

    public Subject createSubject(Subject subject) {
        subject.setSubjectId(nextId++);
        subjects.add(subject);
        return subject;
    }

    public Optional<Subject> updateSubject(Long id, Subject updatedSubject) {
        return getSubjectById(id).map(subject -> {
            subject.setName(updatedSubject.getName());
            subject.setTeacher(updatedSubject.getTeacher());
            return subject;
        });
    }

    public boolean deleteSubject(Long id) {
        return subjects.removeIf(subject -> subject.getSubjectId().equals(id));
    }
}
