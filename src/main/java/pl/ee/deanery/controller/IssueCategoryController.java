package pl.ee.deanery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ee.deanery.model.IssueCategoryEntity;
import pl.ee.deanery.repository.IssueCategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/issue-category")
public class IssueCategoryController {

    @Autowired
    private IssueCategoryRepository repository;

    @GetMapping("/list")
    public List<IssueCategoryEntity> listOfIssueCategories(){
        return repository.findAll();
    }

    @PostMapping("/new")
    public IssueCategoryEntity newIssueCategory(@RequestBody IssueCategoryEntity entity){
        return repository.save(entity);
    }

}
