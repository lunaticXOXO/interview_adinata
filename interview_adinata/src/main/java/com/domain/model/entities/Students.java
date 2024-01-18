package com.domain.model.entities;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import jakarta.persistence.CascadeType;
import java.util.List;

@Entity
@Table(name="students")
public class Students implements Serializable {

    @Id
    private String nim;
    private String name;
    private String adress;
    private String city;
    private String telephone;
    
    @ManyToOne
    @JoinColumn
    private Major major;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
        name = "students_course",
        joinColumns = {
            @JoinColumn(name = "students_id", referencedColumnName = "nim")
        },
        inverseJoinColumns = {
            @JoinColumn(name="subjects_id", referencedColumnName = "code")
        }

    )
    private List<Subjects> subjects;

    public Students(){

    }

    public Students(String nim, String name, String adress, String city, String telephone, Major major) {
        this.nim = nim;
        this.name = name;
        this.adress = adress;
        this.city = city;
        this.telephone = telephone;
        this.major = major;
    }

  

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

 

    

}
