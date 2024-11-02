package com.kss.studentmanagementapi.service;

import com.kss.studentmanagementapi.model.Subject;
import com.kss.studentmanagementapi.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Teacher entities.
 * Provides methods for CRUD operations on teachers,
 * allowing for teacher retrieval, creation, updating, and deletion.
 */
@Service
public class TeacherService {

    /** List of teachers stored in-memory. */
    private List<Teacher> teachers = new ArrayList<>();

    /** Counter for generating unique teacher IDs. */
    private Long nextId = 1L;

    /**
     * Default constructor initializing TeacherService with sample data for demonstration purposes.
     */
    public TeacherService() {
        teachers.add(new Teacher(nextId++, "Dr. Smith"));
    }

    /**
     * Retrieves all teachers.
     *
     * @return a list of all teachers
     */
    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    /**
     * Retrieves a teacher by their unique ID.
     *
     * @param id the unique identifier of the teacher
     * @return an Optional containing the teacher if found, otherwise empty
     */
    public Optional<Teacher> getTeacherById(Long id) {
        return teachers.stream().filter(teacher -> teacher.getTeacherId().equals(id)).findFirst();
    }

    /**
     * Creates a new teacher and adds them to the list.
     *
     * @param teacher the teacher to be created
     * @return the created teacher with an assigned ID
     */
    public Teacher createTeacher(Teacher teacher) {
        teacher.setTeacherId(nextId++);
        teachers.add(teacher);
        return teacher;
    }

    /**
     * Updates an existing teacher's details based on their unique ID.
     *
     * @param id the unique identifier of the teacher to update
     * @param updatedTeacher the teacher containing updated information
     * @return an Optional containing the updated teacher if found, otherwise empty
     */
    public Optional<Teacher> updateTeacher(Long id, Teacher updatedTeacher) {
        return getTeacherById(id).map(teacher -> {
            teacher.setName(updatedTeacher.getName());
            teacher.setSubjects(updatedTeacher.getSubjects());
            return teacher;
        });
    }

    /**
     * Adds subjects to an existing teacher's list of subjects.
     *
     * @param teacherId the unique identifier of the teacher to whom subjects are added
     * @param subjects the list of subjects to add to the teacher's subjects
     * @return an Optional containing the updated teacher if found, otherwise empty
     */
    public Optional<Teacher> addSubjectsToTeacher(Long teacherId, List<Subject> subjects) {
        return getTeacherById(teacherId).map(teacher -> {
            teacher.getSubjects().addAll(subjects);
            return teacher;
        });
    }

    /**
     * Deletes a teacher by their unique ID.
     *
     * @param id the unique identifier of the teacher to delete
     * @return true if the teacher was deleted, otherwise false
     */
    public boolean deleteTeacher(Long id) {
        return teachers.removeIf(teacher -> teacher.getTeacherId().equals(id));
    }
}
