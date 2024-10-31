package com.kss.studentmanagementapi.model;

import java.util.List;

public class Teacher {
    private Long teacherId;
    private String name;
    private List<String> subjects;

    public Teacher() {}

    public Teacher(Long teacherId, String name, List<String> subjects) {
        this.teacherId = teacherId;
        this.name = name;
        this.subjects = subjects;
    }

    public Teacher(String name, List<String> subjects) {
        this.name = name;
        this.subjects = subjects;
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

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
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