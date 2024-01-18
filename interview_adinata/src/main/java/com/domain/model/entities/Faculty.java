package com.domain.model.entities;
import java.io.Serializable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name="faculty")
public class Faculty  implements Serializable {
    
    @Id
    private String id;
    private String faculty_name;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List <Major> majorList;

    public Faculty() {
        
    }

    public Faculty(String id, String faculty_name, List<Major> majorList) {
        this.id = id;
        this.faculty_name = faculty_name;
        this.majorList = majorList;
    }

    public void setId(String id) {
        this.id = id;
    }
   

    public List<Major> getMajorList() {
        return majorList;
    }

    public void setMajorList( List<Major> majorList) {
        this.majorList = majorList;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public String getId() {
        return id;
    }

    public String getFaculty_name() {
        return faculty_name;
    }


}
