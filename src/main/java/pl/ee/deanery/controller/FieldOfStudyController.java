package pl.ee.deanery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ee.deanery.model.FieldOfStudyEntity;
import pl.ee.deanery.service.FieldOfStudyService;

import java.util.List;

@RestController
@RequestMapping("/field-of-study")
public class FieldOfStudyController {

    @Autowired
    private FieldOfStudyService service;

    @GetMapping("/list")
    public List<FieldOfStudyEntity> listOfFieldsOfStudy(){
        return service.getAllFieldsOfStudy();
    }

    @PostMapping("/new")
    public FieldOfStudyEntity newFieldOfStudy(@RequestBody FieldOfStudyEntity entity){
        return service.addFieldOfStudy(entity);
    }


}
