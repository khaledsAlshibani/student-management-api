package com.kss.studentmanagementapi.model;

import java.util.List;

public class Teacher {
    private Long teacherId;
    private String name;
    private List<Subject> subjects;

    public Teacher() {}

    public Teacher(Long teacherId, String name, List<Subject> subjects) {
        this.teacherId = teacherId;
        this.name = name;
        this.subjects = subjects;
    }

    public Teacher(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(Long teacherId, String name) {
        this.teacherId = teacherId;
        this.name = name;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}