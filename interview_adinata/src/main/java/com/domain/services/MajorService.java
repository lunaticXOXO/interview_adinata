package com.domain.services;
import com.domain.model.entities.Major;
import com.domain.model.entities.Faculty;
import com.domain.model.repositories.MajorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
@Service
@Transactional
public class MajorService {
    
    private MajorRepository majorRepo;
    

    public MajorService(MajorRepository majorRepo){
        this.majorRepo = majorRepo;
    }

    public List<Major> show(){
        return majorRepo.QueryShowMajor();
    }

    public Major find(String idmajor){
        return majorRepo.QueryShowMajorId(idmajor);
    } 
    

    public void creates(Major major, Faculty faculty) {
        majorRepo.QueryAddMajor(major.getIdmajor(), major.getAkreditasi(),faculty.getId(), major.getMajorname(), major.getTahunsk(), faculty.getId());

    }

    public void update(Major major, Faculty faculty){
        majorRepo.QueryUpdateMajor(major.getAkreditasi(),faculty.getId(),major.getMajorname(),major.getTahunsk(),faculty.getId(),major.getIdmajor());
    }
    

    public void delete(String id){
        majorRepo.QueryDeleteMajor(id);
    }

}
