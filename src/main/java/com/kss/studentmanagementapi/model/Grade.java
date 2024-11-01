package com.kss.studentmanagementapi.model;

public class Grade {
    private Long gradeId;
    private Subject subject;
    private Double score;

    public Grade(Long gradeId, Subject subject, Double score) {
        this.gradeId = gradeId;
        this.subject = subject;
        this.score = score;
    }

    public Grade(Subject subject, Double score) {
        this.subject = subject;
        this.score = score;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", subject=" + subject +
                ", score=" + score +
                '}';
    }
}
