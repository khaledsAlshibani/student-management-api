package com.kss.studentmanagementapi.model;

/**
 * Represents a Grade associated with a particular subject and score.
 * A Grade is uniquely identified by its gradeId and holds information
 * about the subject and the score achieved.
 */
public class Grade {

    /** Unique identifier for the grade. */
    private Long gradeId;

    /** The subject associated with the grade. */
    private Subject subject;

    /** The score achieved in the subject. */
    private Double score;

    /**
     * Constructs a Grade with specified grade ID, subject, and score.
     *
     * @param gradeId the unique identifier of the grade
     * @param subject the subject associated with this grade
     * @param score the score achieved
     */
    public Grade(Long gradeId, Subject subject, Double score) {
        this.gradeId = gradeId;
        this.subject = subject;
        this.score = score;
    }

    /**
     * Constructs a Grade with specified subject and score.
     * This constructor is typically used when a grade ID is not yet available.
     *
     * @param subject the subject associated with this grade
     * @param score the score achieved
     */
    public Grade(Subject subject, Double score) {
        this.subject = subject;
        this.score = score;
    }

    /**
     * Retrieves the unique identifier of the grade.
     *
     * @return the grade ID
     */
    public Long getGradeId() {
        return gradeId;
    }

    /**
     * Sets the unique identifier of the grade.
     *
     * @param gradeId the grade ID to set
     */
    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    /**
     * Retrieves the subject associated with this grade.
     *
     * @return the subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Sets the subject associated with this grade.
     *
     * @param subject the subject to set
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * Retrieves the score achieved in this grade.
     *
     * @return the score
     */
    public Double getScore() {
        return score;
    }

    /**
     * Sets the score achieved in this grade.
     *
     * @param score the score to set
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * Returns a string representation of the grade, including its ID, subject, and score.
     *
     * @return a string representation of the grade
     */
    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", subject=" + subject +
                ", score=" + score +
                '}';
    }
}