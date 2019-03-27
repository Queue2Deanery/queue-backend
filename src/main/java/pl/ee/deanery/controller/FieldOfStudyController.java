package pl.ee.deanery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ee.deanery.model.FieldOfStudyEntity;
import pl.ee.deanery.repository.FieldOfStudyRepository;

import java.util.List;

@RestController
@RequestMapping("/field-of-study")
public class FieldOfStudyController {

    @Autowired
    private FieldOfStudyRepository fieldOfStudyRepository;

    @GetMapping("/list")
    public List<FieldOfStudyEntity> listOfFieldsOfStudy(){
        return fieldOfStudyRepository.findAll();
    }

    @PostMapping("/new")
    public FieldOfStudyEntity newFieldOfStudy(@RequestBody FieldOfStudyEntity entity){
        return fieldOfStudyRepository.save(entity);
    }

}
