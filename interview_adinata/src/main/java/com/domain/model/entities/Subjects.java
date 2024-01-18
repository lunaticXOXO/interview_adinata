package com.domain.model.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name="subjects")
public class Subjects implements Serializable {
    
    @Id
    private String code;
    private String nama;
    private int semester;
    private int sks;

    @ManyToOne
    @JoinColumn
    private Major major;

    @ManyToOne
    @JoinColumn
    private Lecturer lecturer;

    @ManyToMany(mappedBy = "subjects", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Students> students;


    public Subjects(String code, String nama, int semester, int sks) {
        this.code = code;
        this.nama = nama;
        this.semester = semester;
        this.sks = sks;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }   
    
    

}
