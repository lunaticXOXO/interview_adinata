package com.domain.model.entities;

public class SubjectStudentsDTO {
    
    private Subjects subjects;
    private Students students;
   
    public SubjectStudentsDTO(Subjects subjects, Students students) {
        this.subjects = subjects;
        this.students = students;
       
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }


}
