package com.domain.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.domain.services.MajorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.domain.model.entities.Major;
import com.domain.model.entities.MajorDTO;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap; 
import java.util.Map;

@RestController
@RequestMapping("/api/major")
public class MajorController {
    
    private MajorService majorService;

    public MajorController(MajorService majorService){
        this.majorService = majorService;
    }

    @GetMapping("/show")
    public List<Major> ShowMajor(){
        return majorService.show();
    }

    @GetMapping("/find/{idmajor}")
    public Major FindMajor(String id){
        return majorService.find(id);
    }

    @PostMapping("/add_new")
    public ResponseEntity<Map<String,String>> AddMajorNew(@RequestBody MajorDTO major){
        Map<String, String> response = new HashMap<>();

        try{   

            majorService.creates(major.getMajor(), major.getFaculty());
            response.put("status", "success");
            response.put("message", "Major inserted successfully.");

            return ResponseEntity.ok(response);

        }catch(Exception e){
             response.put("status", "error");
            response.put("message", "Error inserting major" + e.getMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }


    @PutMapping("/update/{idmajor}")
    public ResponseEntity<Map<String, String>> UpdateMajor(@RequestBody MajorDTO major){
        Map<String,String> response = new HashMap<>();
        try{
            majorService.update(major.getMajor(), major.getFaculty());
            response.put("status", "success");
            response.put("message", "Major updated successfully.");

            return ResponseEntity.ok(response);

        }catch(Exception e){
            response.put("status", "error");
            response.put("message", "Error update major" + e.getMessage());

           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

        }
    }

    @DeleteMapping("/delete/{idmajor}")
    public ResponseEntity<Map<String, String>> DeleteMajor(@PathVariable String idmajor){
        Map<String,String> response = new HashMap<>();
        try{
            majorService.delete(idmajor);
            response.put("status", "success");
            response.put("message", "Major delete successfully.");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("status", "error");
            response.put("message", "Error delete major" + e.getMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    
}
