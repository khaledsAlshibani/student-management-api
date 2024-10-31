package com.kss.studentmanagementapi.model;

import java.util.Date;
import java.util.List;

public class Student {
    private Long studentId;
    private String name;
    private Date birthDate;
    private String birthPlace;
    private String gender;
    private String enrollmentStatus;
    private List<Grade> grades;
    private String photoUrl;

    public Student() {}

    public Student(Long studentId, String name, Date birthDate, String birthPlace, String gender, String enrollmentStatus, List<Grade> grades, String photoUrl) {
        this.studentId = studentId;
        this.name = name;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.gender = gender;
        this.enrollmentStatus = enrollmentStatus;
        this.grades = grades;
        this.photoUrl = photoUrl;
    }

    public Student(String name, Date birthDate, String birthPlace, String gender, String enrollmentStatus, List<Grade> grades, String photoUrl) {
        this.name = name;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.gender = gender;
        this.enrollmentStatus = enrollmentStatus;
        this.grades = grades;
        this.photoUrl = photoUrl;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +
                ", gender='" + gender + '\'' +
                ", enrollmentStatus='" + enrollmentStatus + '\'' +
                ", grades=" + grades +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
