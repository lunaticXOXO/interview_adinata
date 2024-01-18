package com.domain.services;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.domain.model.entities.Faculty;
import com.domain.model.repositories.FacultyRepository;
import jakarta.transaction.Transactional;
import java.util.List;


@Component
@Service
@Transactional
public class FacultyService {
    
    private FacultyRepository facultyRepository;
    

    public FacultyService(FacultyRepository facultyRepository){
        this.facultyRepository = facultyRepository;
    }

    public List<Faculty> show(){
        return facultyRepository.ShowFaculty();
    }
  

    public Faculty find(String id){
        return facultyRepository.ShowFacultyById(id);
    }

    public void create(Faculty faculty){
       facultyRepository.InsertFaculty(faculty.getId(), faculty.getFaculty_name());
    }

    public void update(Faculty faculty){
        facultyRepository.UpdateFaculty(faculty.getFaculty_name(), faculty.getId());
    }

    public void delete(String id){
        facultyRepository.DeleteFaculty(id);
    }
}
