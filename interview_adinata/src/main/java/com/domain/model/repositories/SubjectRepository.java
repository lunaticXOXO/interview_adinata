package com.domain.model.repositories;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import com.domain.model.entities.Subjects;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.repository.query.Param;

@Component
public interface SubjectRepository extends Repository <Subjects,String> {

    @Query(value = "SELECT * FROM subjects",nativeQuery = true)
    List<Subjects> QuerySubjects();

    @Modifying
    @Transactional
    @Query(value="INSERT INTO subjects(code,nama,semester,sks,lecturer_nip,major_idmajor)VALUES(:code, :nama, :semester, :sks, :lecturer_nip, :major_idmajor)",nativeQuery = true)
    void QueryAddSubjects(
        @Param("code") String code,
        @Param("nama") String nama,
        @Param("semester") int semester,
        @Param("sks") int sks,
        @Param("lecturer_nip") String lecturer_nip,
        @Param("major_idmajor") String major_idmajor

    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE subjects SET nama = :nama, semester = :semester, sks = :sks, lecturer_nip = :lecturer_nip, major_idmajor = :major_idmajor WHERE code = :code",nativeQuery = true)    
    void QueryUpdateSubjects(
        @Param("nama") String nama,
        @Param("semester") int semester,
        @Param("sks") int sks,
        @Param("lecturer_nip") String lecturer_nip,
        @Param("major_idmajor") String major_idmajor,
        @Param("code") String code
        
    );

   



    @Modifying
    @Transactional
    @Query(value = "DELETE FROM subjects WHERE code = :code",nativeQuery = true)
    void QueryDeleteSubjects(@Param("code") String code);
}
