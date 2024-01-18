package com.domain.model.entities;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "lecturer")
public class Lecturer implements Serializable {
    
    @Id
    private String nip;
    private String name;
    private String adress;
    private String city;
    private String telephone;

    @ManyToOne
    @JoinColumn
    private Major major;

    @OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL )
    private List<Subjects> subjects;

    public Lecturer(){

    }

    public Lecturer(String nip, String name, String adress, String city, String telephone) {
        this.nip = nip;
        this.name = name;
        this.adress = adress;
        this.city = city;
        this.telephone = telephone;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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
