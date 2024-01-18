package com.domain.services;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.domain.model.entities.Lecturer;
import com.domain.model.entities.Major;
import com.domain.model.entities.Subjects;
import com.domain.model.repositories.MajorRepository;
import com.domain.model.repositories.SubjectRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;

import jakarta.transaction.Transactional;

@Component
@Service
@Transactional
public class SubjectService {
    
    private SubjectRepository subjectRepository;
    private MajorRepository majorRepository;

    private List<Major> listMajor;
    private List<Major> majorSelected;


    public SubjectService(SubjectRepository subjectRepository, MajorRepository majorRepository){
        this.subjectRepository = subjectRepository;
        this.majorRepository = majorRepository;
    }

    public void create_byMajor(Subjects subjects, Major major, Lecturer lecturer, @PathVariable String idmajor ){

        listMajor = majorRepository.QueryShowMajor();
        majorSelected = listMajor.stream()
                        .filter(majors -> major.getIdmajor().equals(idmajor))
                        .collect(Collectors.toList());

         if (!majorSelected.isEmpty()){
              major.setIdmajor(majorSelected.get(0).getIdmajor());
         }
         
         subjectRepository.QueryAddSubjects(
            subjects.getCode(), 
            subjects.getNama(),
            subjects.getSemester(), 
            subjects.getSks(), 
            lecturer.getNip(), 
            major.getIdmajor());
    }



    public void update(Subjects subjects, Major majors, Lecturer lecturer){
        subjectRepository.QueryUpdateSubjects(
            subjects.getNama(),
            subjects.getSemester(), 
            subjects.getSks(),
            lecturer.getNip(),
            majors.getIdmajor(),
            subjects.getCode());
    }

    public void delete(String code){
        subjectRepository.QueryDeleteSubjects(code);
    }

}
