package com.domain.model.repositories;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.domain.model.entities.Major;


import jakarta.transaction.Transactional;

import java.util.List;

@Component
public interface MajorRepository extends Repository <Major,String> {

    @Query(value="SELECT *  FROM  major",nativeQuery = true)
    List<Major> QueryShowMajor();

    @Query(value = "SELECT * FROM major WHERE idmajor = :idmajor",nativeQuery = true)
    Major QueryShowMajorId(String idmajor);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO major(idmajor,akreditasi,faculty,majorname,tahunsk,faculty_id)VALUES(:idmajor, :akreditasi, :faculty,:majorname,:tahunsk, :faculty_id)", nativeQuery = true)
    void QueryAddMajor(
            @Param("idmajor") String idmajor, 
            @Param("akreditasi") String akreditasi, 
            @Param("faculty") String faculty,  
            @Param("majorname") String majorname, 
            @Param("tahunsk") String tahunsk, 
            @Param("faculty_id") String facultyid );

   
    @Modifying
    @Transactional
    @Query(value = "UPDATE major SET akreditasi = :akreditasi, faculty = :faculty, majorname = :majorname, tahunsk = :tahunsk, facultyid = :facultyid WHERE idmajor = :idmajor", nativeQuery = true)
    void QueryUpdateMajor(
        @Param("akreditasi") String akreditasi, 
        @Param("faculty") String faculty , 
        @Param("majorname") String majorname, 
        @Param("tahunsk") String tahunsk, 
        @Param("facultyid") String facultyid, 
        @Param("idmajor") String idmajor);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM major WHERE idmajor = :idmajor",nativeQuery = true)
    void QueryDeleteMajor(@Param("idmajor") String idmajor);

}
