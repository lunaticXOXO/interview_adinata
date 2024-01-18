package com.domain.controllers;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.services.FacultyService;
import com.domain.model.entities.Faculty;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/faculties")
public class FacultyController {
    
   
    private FacultyService facultyService;

   
    public FacultyController(FacultyService facultyService){
        this.facultyService = facultyService;
    }


    @GetMapping("/show")
    public List<Faculty> ShowFaculty(){
        return facultyService.show();
    }

    @GetMapping("/find/{id}")
    public Faculty FindFaculty( @PathVariable String id){
        return facultyService.find(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> AddFaculty( @RequestBody Faculty faculty){
      Map<String, String> response = new HashMap<>();

        try{

            facultyService.create(faculty);
            response.put("status", "success");
            response.put("message", "Faculty inserted successfully.");

            return ResponseEntity.ok(response);
          
        }catch(Exception e){
            response.put("status", "error");
            response.put("message", "Error inserting faculty" + e.getMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
      
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, String>> UpdateFaculty(@RequestBody Faculty faculty){
        Map<String,String> response = new HashMap<>();
        try{
            facultyService.update(faculty);
            response.put("status", "success");
            response.put("message", "Faculty updated successfully.");
            return ResponseEntity.ok(response);

        }catch(Exception e){
            response.put("status", "error");
            response.put("message", "Error update faculty" + e.getMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,String>> DeleteFaculty(@PathVariable String id){
        Map<String,String> response = new HashMap<>();

        try{
            facultyService.delete(id);
            response.put("status", "success");
            response.put("message", "Faculty delete successfully.");
            return ResponseEntity.ok(response);

        }catch(Exception e){
            response.put("status", "error");
            response.put("message", "Error delete faculty" + e.getMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

        }

    }
}

