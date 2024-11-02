package com.kss.studentmanagementapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

/**
 * Represents a Teacher who instructs one or more subjects.
 * A Teacher is uniquely identified by teacherId and includes details
 * such as the teacher's name and the list of subjects they teach.
 */
public class Teacher {

    /** Unique identifier for the teacher. */
    private Long teacherId;

    /** The full name of the teacher. */
    private String name;

    /** List of subjects taught by the teacher. - notation manages serialization reference */
    @JsonManagedReference
    private List<Subject> subjects;

    /**
     * Default constructor for creating an empty Teacher instance.
     */
    public Teacher() {}

    /**
     * Constructs a Teacher with a specified teacher ID, name, and list of subjects.
     *
     * @param teacherId the unique identifier for the teacher
     * @param name the full name of the teacher
     * @param subjects the list of subjects taught by the teacher
     */
    public Teacher(Long teacherId, String name, List<Subject> subjects) {
        this.teacherId = teacherId;
        this.name = name;
        this.subjects = subjects;
    }

    /**
     * Constructs a Teacher with specified name and list of subjects.
     * Typically used when a teacher ID is not yet available.
     *
     * @param name the full name of the teacher
     * @param subjects the list of subjects taught by the teacher
     */
    public Teacher(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    /**
     * Constructs a Teacher with a specified name.
     *
     * @param name the full name of the teacher
     */
    public Teacher(String name) {
        this.name = name;
    }

    /**
     * Constructs a Teacher with a specified teacher ID and name.
     *
     * @param teacherId the unique identifier for the teacher
     * @param name the full name of the teacher
     */
    public Teacher(Long teacherId, String name) {
        this.teacherId = teacherId;
        this.name = name;
    }

    /** @return the unique identifier of the teacher */
    public Long getTeacherId() {
        return teacherId;
    }

    /** @param teacherId the teacher ID to set */
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    /** @return the full name of the teacher */
    public String getName() {
        return name;
    }

    /** @param name the name to set */
    public void setName(String name) {
        this.name = name;
    }

    /** @return the list of subjects taught by the teacher */
    public List<Subject> getSubjects() {
        return subjects;
    }

    /** @param subjects the subjects to set */
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    /**
     * Returns a string representation of the Teacher, including teacher ID, name, and subjects taught.
     *
     * @return a string representation of the teacher
     */
    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
