package com.domain.services;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.domain.model.repositories.StudentsRepository;
import com.domain.model.repositories.SubjectRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import com.domain.model.entities.Students;
import com.domain.model.entities.Major;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@Service
@Transactional
public class StudentService {
    
    private StudentsRepository studentsRepository;
  

    public StudentService(StudentsRepository studentsRepository, SubjectRepository subjectRepository){
        this.studentsRepository = studentsRepository;
       
    }

    public List<Students> show(){
        return studentsRepository.QueryStudents()
        .stream()
        .collect(Collectors.toList());
    }

    public List<Students> search(@PathVariable String name){
          return studentsRepository.QueryStudents()
                .stream()
                .filter(students -> students.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }


    public void create(Students students, Major major){
        studentsRepository.QueryAddStudents(
            students.getNim(), students.getAdress(), 
            students.getCity(), students.getName(), 
            students.getTelephone(),
            major.getIdmajor());
    }

   

    public void update(Students students, Major major){
        studentsRepository.QueryUpdateStudents(
                        students.getAdress(), 
                        students.getCity(), 
                        students.getName(), 
                        students.getTelephone(),
                        major.getIdmajor(),
                        students.getNim());
    }

    public void delete(String nim){
        studentsRepository.QueryDeleteStudents(nim);
    }


}
