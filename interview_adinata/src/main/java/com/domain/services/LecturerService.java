package com.domain.services;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.domain.model.repositories.LecturerRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import com.domain.model.entities.Lecturer;
import com.domain.model.entities.Major;
import java.util.stream.Collectors;

@Component
@Service
@Transactional
public class LecturerService {
    

    private LecturerRepository lecturerRepo;
   

    public LecturerService(LecturerRepository lecturerRepo){
        this.lecturerRepo = lecturerRepo;
    }

    public List<Lecturer> show(){
        return lecturerRepo.QueryShowLecturer();
    }

    public List<Lecturer> findByStream(String nip){
        return lecturerRepo.QueryShowLecturer()
        .stream()
        .filter(lecturer -> lecturer.getNip().equals(nip))
        .collect(Collectors.toList());
    }

    public List<Lecturer> searchByStream(@PathVariable String nama) {
        return lecturerRepo.QueryShowLecturer()
                .stream()
                .filter(lecturer -> lecturer.getName().toLowerCase().contains(nama.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void create(Lecturer lecturer, Major major){
        lecturerRepo.QueryAddLecturer(lecturer.getNip(), lecturer.getAdress(),lecturer.getCity(), lecturer.getName(), lecturer.getTelephone(), major.getIdmajor());
    }

    public void update(Lecturer lecturer, Major major){
        lecturerRepo.QueryUpdateLecturer(lecturer.getAdress(),lecturer.getCity(), lecturer.getName(), lecturer.getTelephone(), major.getIdmajor(),lecturer.getNip());
    }


    public void delete(String nip){
        lecturerRepo.QueryDeleteLecturer(nip);
    }

}
