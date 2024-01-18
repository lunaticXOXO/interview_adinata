package com.domain.model.entities;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name="major")
public class Major implements Serializable {

    @Id
    @Column(name="idmajor")
    private String idmajor;

    @Column(name="majorname")
    private String majorname;

    @Column(name="akreditasi")
    private String akreditasi;

    @Column(name="tahunsk")
    private String tahunsk;

    @OneToMany(mappedBy = "major",cascade = CascadeType.ALL)
    private List<Students> listStudents;

    @OneToMany(mappedBy = "major", cascade = CascadeType.ALL)
     private List <Lecturer> listLecturer;

    @OneToMany(mappedBy = "major",cascade = CascadeType.ALL)
    private List<Subjects> listSubjects;

    @ManyToOne
    @JoinColumn(name="faculty_id")
    private Faculty faculty;

    public Major() {
        
    }

    public Major(String idmajor, String majorname, String akreditasi, String tahunsk, List<Students> listStudents) {
        this.idmajor = idmajor;
        this.majorname = majorname;
        this.akreditasi = akreditasi;
        this.tahunsk = tahunsk;
        this.listStudents = listStudents;
       
    }

    
    public List<Students> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Students> listStudents) {
        this.listStudents = listStudents;
    }

    public String getIdmajor() {
        return idmajor;
    }

    public void setIdmajor(String idmajor) {
        this.idmajor = idmajor;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    public String getAkreditasi() {
        return akreditasi;
    }

    public void setAkreditasi(String akreditasi) {
        this.akreditasi = akreditasi;
    }

    public String getTahunsk() {
        return tahunsk;
    }

    public void setTahunsk(String tahunsk) {
        this.tahunsk = tahunsk;
    }

    
    

}
