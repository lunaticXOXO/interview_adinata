package com.domain.model.entities;
import java.io.Serializable;
//import jakarta.persistence.Entity;


public class MajorDTO  implements Serializable {
    
    private Major major;
    private Faculty faculty;
   

    public MajorDTO(Major major, Faculty faculty) {
        this.major = major;
        this.faculty = faculty;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }


    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    
    
}
