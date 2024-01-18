package com.domain.model.repositories;

import com.domain.model.entities.Faculty;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Component;

import java.util.List;


public interface FacultyRepository extends Repository <Faculty,String> {

    @Query(value= "SELECT * FROM faculty",nativeQuery = true)
    List<Faculty> ShowFaculty();
    
    @Query(value = "SELECT * FROM faculty WHERE id = :id ",nativeQuery = true)
    Faculty ShowFacultyById(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO faculty(id,faculty_name)VALUES(:id, :faculty_name)",nativeQuery = true)
    void InsertFaculty(
        @Param("id") String id, 
        @Param("faculty_name") String faculty_name );


    @Modifying
    @Transactional
    @Query(value = "UPDATE faculty SET faculty_name = :faculty_name WHERE id = :id",nativeQuery = true)
    void UpdateFaculty(
        @Param("faculty_name") String faculty_name, 
        @Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM faculty Where id = :id",nativeQuery = true)
    void DeleteFaculty(@Param("id") String id);

} 