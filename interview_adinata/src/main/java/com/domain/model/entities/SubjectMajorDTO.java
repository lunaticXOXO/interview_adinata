package com.domain.model.entities;

public class SubjectMajorDTO {
    
    private Subjects subjects;
    private Major major;
    private Lecturer lecturer;
    
    public SubjectMajorDTO(Subjects subjects, Major major, Lecturer lecturer) {
        this.subjects = subjects;
        this.major = major;
        this.lecturer = lecturer;
    }
    public Subjects getSubjects() {
        return subjects;
    }
    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }
    public Major getMajor() {
        return major;
    }
    public void setMajor(Major major) {
        this.major = major;
    }
    public Lecturer getLecturer() {
        return lecturer;
    }
    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    
}
