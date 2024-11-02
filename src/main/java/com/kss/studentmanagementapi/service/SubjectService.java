package com.kss.studentmanagementapi.service;

import com.kss.studentmanagementapi.model.Subject;
import com.kss.studentmanagementapi.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Subject entities.
 * Provides methods for CRUD operations on subjects,
 * allowing for subject retrieval, creation, updating, and deletion.
 */
@Service
public class SubjectService {

    /** Service for retrieving Teacher information. */
    private final TeacherService teacherService;

    /** List of subjects stored in-memory. */
    private List<Subject> subjects = new ArrayList<>();

    /** Counter for generating unique subject IDs. */
    private Long nextId = 1L;

    /**
     * Constructor for SubjectService initializing with sample data for demonstration purposes.
     *
     * @param teacherService the TeacherService used for retrieving teachers
     */
    public SubjectService(TeacherService teacherService) {
        // Sample data for demonstration purposes
        Teacher teacher = new Teacher(1L, "Dr. Smith");
        subjects.add(new Subject(nextId++, "Math", teacher));
        subjects.add(new Subject(nextId++, "Physics", teacher));
        this.teacherService = teacherService;
    }

    /**
     * Retrieves all subjects.
     *
     * @return a list of all subjects
     */
    public List<Subject> getAllSubjects() {
        return subjects;
    }

    /**
     * Retrieves a subject by its unique ID.
     *
     * @param id the unique identifier of the subject
     * @return an Optional containing the subject if found, otherwise empty
     */
    public Optional<Subject> getSubjectById(Long id) {
        return subjects.stream().filter(subject -> subject.getSubjectId().equals(id)).findFirst();
    }

    /**
     * Creates a new subject and assigns a teacher based on the teacher ID in the subject.
     *
     * @param subject the subject to be created
     * @return the created subject with an assigned ID and teacher
     */
    public Subject createSubject(Subject subject) {
        Teacher teacher = teacherService.getTeacherById(subject.getTeacher().getTeacherId())
                .orElse(null);

        subject.setTeacher(teacher);
        subject.setSubjectId(nextId++);
        subjects.add(subject);
        return subject;
    }

    /**
     * Updates an existing subject's details based on its unique ID.
     *
     * @param id the unique identifier of the subject to update
     * @param updatedSubject the subject containing updated information
     * @return an Optional containing the updated subject if found, otherwise empty
     */
    public Optional<Subject> updateSubject(Long id, Subject updatedSubject) {
        return getSubjectById(id).map(subject -> {
            subject.setName(updatedSubject.getName());
            subject.setTeacher(updatedSubject.getTeacher());
            return subject;
        });
    }

    /**
     * Deletes a subject by its unique ID.
     *
     * @param id the unique identifier of the subject to delete
     * @return true if the subject was deleted, otherwise false
     */
    public boolean deleteSubject(Long id) {
        return subjects.removeIf(subject -> subject.getSubjectId().equals(id));
    }
}
