package com.domain.model.entities;

public class StudentsMajorDTO {
    
    private Students students;
    private Major major;

    public StudentsMajorDTO(Students students, Major major) {
        this.students = students;
        this.major = major;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    
    
}
