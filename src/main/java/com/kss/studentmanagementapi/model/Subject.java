package com.kss.studentmanagementapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represents a Subject that a student can study, taught by a specific teacher.
 * A Subject is uniquely identified by its subjectId and includes details
 * such as the name and the assigned teacher.
 */
public class Subject {

    /** Unique identifier for the subject. */
    private Long subjectId;

    /** The name of the subject (e.g., Mathematics, Science). */
    private String name;

    /** The teacher assigned to this subject. - notation used to prevents circular reference in JSON output, backs reference to avoid circular reference */
    @JsonIgnore
    @JsonBackReference
    private Teacher teacher;

    /**
     * Default constructor for creating an empty Subject instance.
     */
    public Subject() {}

    /**
     * Constructs a Subject with a specified subject ID, name, and teacher.
     *
     * @param subjectId the unique identifier for the subject
     * @param name the name of the subject
     * @param teacher the teacher assigned to this subject
     */
    public Subject(Long subjectId, String name, Teacher teacher) {
        this.subjectId = subjectId;
        this.name = name;
        this.teacher = teacher;
    }

    /**
     * Constructs a Subject with specified name and teacher, without a subject ID.
     *
     * @param name the name of the subject
     * @param teacher the teacher assigned to this subject
     */
    public Subject(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    /** @return the unique identifier of the subject */
    public Long getSubjectId() {
        return subjectId;
    }

    /** @param subjectId the subject ID to set */
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    /** @return the name of the subject */
    public String getName() {
        return name;
    }

    /** @param name the name to set */
    public void setName(String name) {
        this.name = name;
    }

    /** @return the teacher assigned to this subject */
    public Teacher getTeacher() {
        return teacher;
    }

    /** @param teacher the teacher to set */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * Returns a string representation of the Subject, including subject ID, name, and teacher.
     *
     * @return a string representation of the subject
     */
    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
