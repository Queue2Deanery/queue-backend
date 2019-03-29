package pl.ee.deanery.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ee.deanery.model.FieldOfStudyEntity;
import pl.ee.deanery.repository.FieldOfStudyRepository;

import java.util.List;

@Service
public class FieldOfStudyService {

    @Autowired
    private FieldOfStudyRepository repository;

    public FieldOfStudyEntity addFieldOfStudy(FieldOfStudyEntity fieldOfStudy){
        return repository.save(fieldOfStudy);
    }

    public List<FieldOfStudyEntity> getAllFieldsOfStudy(){
        return repository.findAll();
    }

}
