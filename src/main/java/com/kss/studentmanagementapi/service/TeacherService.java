package com.kss.studentmanagementapi.service;

import com.kss.studentmanagementapi.model.Subject;
import com.kss.studentmanagementapi.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private List<Teacher> teachers = new ArrayList<>();
    private Long nextId = 1L;

    public TeacherService() {
        teachers.add(new Teacher(nextId++, "Dr. Smith"));
    }

    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teachers.stream().filter(teacher -> teacher.getTeacherId().equals(id)).findFirst();
    }

    public Teacher createTeacher(Teacher teacher) {
        teacher.setTeacherId(nextId++);
        teachers.add(teacher);
        return teacher;
    }

    public Optional<Teacher> updateTeacher(Long id, Teacher updatedTeacher) {
        return getTeacherById(id).map(teacher -> {
            teacher.setName(updatedTeacher.getName());
            teacher.setSubjects(updatedTeacher.getSubjects());
            return teacher;
        });
    }

    // Method to add subjects to a teacher
    public Optional<Teacher> addSubjectsToTeacher(Long teacherId, List<Subject> subjects) {
        return getTeacherById(teacherId).map(teacher -> {
            teacher.getSubjects().addAll(subjects);
            return teacher;
        });
    }

    public boolean deleteTeacher(Long id) {
        return teachers.removeIf(teacher -> teacher.getTeacherId().equals(id));
    }
}
