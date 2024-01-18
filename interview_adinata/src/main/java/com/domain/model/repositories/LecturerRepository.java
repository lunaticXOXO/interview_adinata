package com.domain.model.repositories;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import com.domain.model.entities.Lecturer;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


@Component
public interface LecturerRepository extends Repository <Lecturer,String> {

    @Query(value = "SELECT * FROM lecturer", nativeQuery = true)
    List<Lecturer> QueryShowLecturer();
   
    @Modifying
    @Transactional
    @Query(value="INSERT INTO lecturer(nip,adress,city,name,telephone,major_idmajor)VALUES(:nip, :adress, :city,:name,:telephone, :major_idmajor)", nativeQuery = true)
    void QueryAddLecturer(
        @Param("nip") String nip, 
        @Param("adress") String adress, 
        @Param("city") String city,  
        @Param("name") String name, 
        @Param("telephone") String telephone,
        @Param("major_idmajor") String major_idmajor 
    );

    
    @Modifying
    @Transactional
    @Query(value = "UPDATE lecturer SET adress = :adress,city = :city, name = :name, telephone = :telephone, major_idmajor = :major_idmajor WHERE nip = :nip", nativeQuery = true)
    void QueryUpdateLecturer(
        @Param("adress") String adress, 
        @Param("city") String city,  
        @Param("name") String name, 
        @Param("telephone") String telephone,
        @Param("major_idmajor") String major_idmajor,
        @Param("nip") String nip 
        
    );


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM lecturer WHERE nip = :nip",nativeQuery = true)
    void QueryDeleteLecturer(
        @Param("nip") String nip
    );
}
