package com.domain.model.repositories;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import com.domain.model.entities.Students;

import jakarta.transaction.Transactional;

import java.util.List;

@Component
public interface StudentsRepository extends Repository <Students, String> {
    
    @Query(value="SELECT * FROM students JOIN major ON students.major_idmajor = major.idmajor", nativeQuery = true)
    List<Students> QueryStudents();

    
    @Modifying
    @Transactional
    @Query(value="INSERT INTO students(nim,adress,city,name,telephone,major_idmajor)VALUES(:nim, :adress, :city,:name,:telephone, :major_idmajor)", nativeQuery = true)
    void QueryAddStudents(
        @Param("nim") String nim, 
        @Param("adress") String adress, 
        @Param("city") String city,  
        @Param("name") String name, 
        @Param("telephone") String telephone,
        @Param("major_idmajor") String major_idmajor 
    );  

   

    @Modifying
    @Transactional
    @Query(value = "UPDATE students SET adress = :adress,city = :city, name = :name, telephone = :telephone, major_idmajor = :major_idmajor WHERE nim = :nim", nativeQuery = true)
    void QueryUpdateStudents(
        @Param("adress") String adress, 
        @Param("city") String city,  
        @Param("name") String name, 
        @Param("telephone") String telephone,
        @Param("major_idmajor") String major_idmajor,
        @Param("nim") String nim 
        
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM students WHERE nim = :nim",nativeQuery = true)
    void QueryDeleteStudents(
        @Param("nim") String nim
    );



}
