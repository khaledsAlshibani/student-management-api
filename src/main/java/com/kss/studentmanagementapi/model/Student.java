package com.kss.studentmanagementapi.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents a Student with personal information, enrollment details,
 * academic grades, and a profile picture.
 */
public class Student {

    /** Unique identifier for the student. */
    private Long studentId;

    /** Full name of the student. */
    private String name;

    /** Date of birth of the student. */
    private LocalDate birthDate;

    /** Place of birth of the student. */
    private String birthPlace;

    /** Gender of the student. */
    private String gender;

    /** Enrollment status of the student (e.g., enrolled, graduated, withdrawn). */
    private String enrollmentStatus;

    /** List of grades associated with the student. */
    private List<Grade> grades;

    /** URL to the student's profile photo. */
    private String photoUrl;

    /**
     * Default constructor for creating an empty Student instance.
     */
    public Student() {
    }

    /**
     * Constructs a Student with all attributes.
     *
     * @param studentId the unique identifier for the student
     * @param name the full name of the student
     * @param birthDate the date of birth of the student
     * @param birthPlace the place of birth of the student
     * @param gender the gender of the student
     * @param enrollmentStatus the current enrollment status of the student
     * @param grades the list of grades associated with the student
     * @param photoUrl the URL of the student's profile photo
     */
    public Student(Long studentId, String name, LocalDate birthDate, String birthPlace, String gender, String enrollmentStatus, List<Grade> grades, String photoUrl) {
        this.studentId = studentId;
        this.name = name;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.gender = gender;
        this.enrollmentStatus = enrollmentStatus;
        this.grades = grades;
        this.photoUrl = photoUrl;
    }

    /**
     * Constructs a Student without a specified ID.
     *
     * @param name the full name of the student
     * @param birthDate the date of birth of the student
     * @param birthPlace the place of birth of the student
     * @param gender the gender of the student
     * @param enrollmentStatus the current enrollment status of the student
     * @param grades the list of grades associated with the student
     * @param photoUrl the URL of the student's profile photo
     */
    public Student(String name, LocalDate birthDate, String birthPlace, String gender, String enrollmentStatus, List<Grade> grades, String photoUrl) {
        this.name = name;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.gender = gender;
        this.enrollmentStatus = enrollmentStatus;
        this.grades = grades;
        this.photoUrl = photoUrl;
    }

    /** @return the unique identifier of the student */
    public Long getStudentId() {
        return studentId;
    }

    /** @param studentId the student ID to set */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /** @return the full name of the student */
    public String getName() {
        return name;
    }

    /** @param name the name to set */
    public void setName(String name) {
        this.name = name;
    }

    /** @return the date of birth of the student */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /** @param birthDate the birth date to set */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /** @return the place of birth of the student */
    public String getBirthPlace() {
        return birthPlace;
    }

    /** @param birthPlace the birth place to set */
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    /** @return the gender of the student */
    public String getGender() {
        return gender;
    }

    /** @param gender the gender to set */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /** @return the current enrollment status of the student */
    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    /** @param enrollmentStatus the enrollment status to set */
    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    /** @return the list of grades associated with the student */
    public List<Grade> getGrades() {
        return grades;
    }

    /** @param grades the grades to set */
    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    /** @return the URL of the student's profile photo */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /** @param photoUrl the photo URL to set */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    /**
     * Returns a string representation of the Student, including ID, name, birth details, gender, enrollment status, grades, and photo URL.
     *
     * @return a string representation of the student
     */
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
