package com.domain.controllers;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.domain.model.entities.SubjectMajorDTO;
import com.domain.services.SubjectService;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    
    private SubjectService subjectService;
   

    public SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @PostMapping("/add_bymajor/{idmajor}")
    public ResponseEntity <Map<String,String>> AddByMajor(@RequestBody SubjectMajorDTO subjectdto, @PathVariable String idmajor){
        Map<String, String> response = new HashMap<>();

        try{

            subjectService.create_byMajor(subjectdto.getSubjects(), subjectdto.getMajor(),subjectdto.getLecturer(), idmajor);
            response.put("status", "success");
            response.put("message", "students add successfully.");

            return ResponseEntity.ok(response);

        }catch(Exception e){
             response.put("status", "error");
            response.put("message", "Error add subject" + e.getMessage());

           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/update/{code}")
    public ResponseEntity <Map<String,String>> UpdateStudents(@RequestBody SubjectMajorDTO subjectdto){
        Map<String, String> response = new HashMap<>();

        try{

            subjectService.update(subjectdto.getSubjects(), subjectdto.getMajor(), subjectdto.getLecturer());
            response.put("status", "success");
            response.put("message", "subject updated successfully.");

            return ResponseEntity.ok(response);

        }catch(Exception e){
             response.put("status", "error");
            response.put("message", "Error update subject" + e.getMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


}
