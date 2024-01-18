package com.domain.model.entities;

public class LecturerMajorDTO {
    
    private Lecturer lecturer;
    private Major major;
    
    public LecturerMajorDTO(Lecturer lecturer, Major major) {
        this.lecturer = lecturer;
        this.major = major;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    
}
