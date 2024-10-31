package com.kss.studentmanagementapi.model;

public class Grade {
    private Subject subject;
    private Double score;

    public Grade(Subject subject, Double score) {
        this.subject = subject;
        this.score = score;
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
                "subject=" + subject +
                ", score=" + score +
                '}';
    }
}
