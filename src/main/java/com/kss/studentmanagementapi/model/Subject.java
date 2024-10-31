package com.kss.studentmanagementapi.model;

public class Subject {
    private Long subjectId;
    private String name;
    private Teacher teacher;

    public Subject() {}

    public Subject(Long subjectId, String name, Teacher teacher) {
        this.subjectId = subjectId;
        this.name = name;
        this.teacher = teacher;
    }

    public Subject(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}