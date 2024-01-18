package com.domain.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.domain.services.StudentService;
import com.domain.model.entities.Students;
import com.domain.model.entities.StudentsMajorDTO;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/show")
    public List<Students> ShowStudent(){
        return studentService.show();
    }

    @GetMapping("/search/{name}")
    public List<Students> SearchStudent(@PathVariable String name){
        return studentService.search(name);
    }

    @PostMapping("/add")
    public ResponseEntity <Map<String,String>> AddStudents(@RequestBody StudentsMajorDTO studentsdto){
        Map<String, String> response = new HashMap<>();

        try{

            studentService.create(studentsdto.getStudents(), studentsdto.getMajor());
            response.put("status", "success");
            response.put("message", "students add successfully.");

            return ResponseEntity.ok(response);

        }catch(Exception e){
             response.put("status", "error");
            response.put("message", "Error add students" + e.getMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

   
    @PutMapping("/update/{nim}")
    public ResponseEntity <Map<String,String>> UpdateStudents(@RequestBody StudentsMajorDTO studentsdto){
        Map<String, String> response = new HashMap<>();

        try{

            studentService.update(studentsdto.getStudents(), studentsdto.getMajor());
            response.put("status", "success");
            response.put("message", "students updated successfully.");

            return ResponseEntity.ok(response);

        }catch(Exception e){
             response.put("status", "error");
            response.put("message", "Error update student" + e.getMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

     @DeleteMapping("/delete/{nim}")
    public ResponseEntity<Map<String, String>> DeletStudents(@PathVariable String nim){
        Map<String,String> response = new HashMap<>();
        try{
            studentService.delete(nim);
            response.put("status", "success");
            response.put("message", " delete successfully.");

            return ResponseEntity.ok(response);

        }catch(Exception e){

            response.put("status", "error");
            response.put("message", "Error delete" + e.getMessage());

           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


}
