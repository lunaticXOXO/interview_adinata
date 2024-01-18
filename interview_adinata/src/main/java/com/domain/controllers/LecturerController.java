package com.domain.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.domain.services.LecturerService;
import com.domain.model.entities.Lecturer;
import com.domain.model.entities.LecturerMajorDTO;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/lecturer")
public class LecturerController {
    
    private LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService){

        this.lecturerService = lecturerService;
    }

    @GetMapping("/show")
    public List<Lecturer> ShowLecturer(){
        return lecturerService.show();
    }


    @GetMapping("/stream/{nip}")
    public List<Lecturer> StreamLecturer(@PathVariable String nip){
        return lecturerService.findByStream(nip);
    }

    @GetMapping("/search_stream/{nama}")
    public List<Lecturer> SerachLecturer(@PathVariable String nama){
        return lecturerService.searchByStream(nama);
    }

    @PostMapping("/add")
    public ResponseEntity <Map<String,String>> AddLecturer(@RequestBody LecturerMajorDTO lecturerdto){
        Map<String, String> response = new HashMap<>();

        try{

            lecturerService.create(lecturerdto.getLecturer(), lecturerdto.getMajor());
            response.put("status", "success");
            response.put("message", "Lecturer add successfully.");

            return ResponseEntity.ok(response);

        }catch(Exception e){
             response.put("status", "error");
            response.put("message", "Error add lecturer" + e.getMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    
    
    @PutMapping("/update/{nip}")
    public ResponseEntity <Map<String,String>> UpdateLecturer(@RequestBody LecturerMajorDTO lecturerdto){
        Map<String, String> response = new HashMap<>();

        try{

            lecturerService.update(lecturerdto.getLecturer(), lecturerdto.getMajor());
            response.put("status", "success");
            response.put("message", "Lecturer update successfully.");

            return ResponseEntity.ok(response);

        }catch(Exception e){
             response.put("status", "error");
            response.put("message", "Error update lecturer" + e.getMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

     @DeleteMapping("/delete/{nip}")
    public ResponseEntity<Map<String, String>> DeleteLecturer(@PathVariable String nip){
        Map<String,String> response = new HashMap<>();
        try{
            lecturerService.delete(nip);
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
