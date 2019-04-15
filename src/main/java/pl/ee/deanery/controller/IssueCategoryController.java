package pl.ee.deanery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ee.deanery.model.IssueCategoryEntity;
import pl.ee.deanery.repository.IssueCategoryRepository;
import pl.ee.deanery.service.IssueCategoryService;

import java.util.List;

@RestController
@RequestMapping("/issue-category")
public class IssueCategoryController {

    @Autowired
    private IssueCategoryService service;

    @GetMapping("/list")
    public List<IssueCategoryEntity> listOfIssueCategories(){
        return service.getAllIssueCategories();
    }

    @PostMapping("/new")
    public IssueCategoryEntity newIssueCategory(@RequestBody IssueCategoryEntity entity){
        return service.addIssueCategory(entity);
    }

    @PutMapping("/edit/{id}")
    public IssueCategoryEntity editIssueCategory(@RequestBody IssueCategoryEntity newIssueCategory,
                                                 @PathVariable Long id){
       return service.editIssueCategory(newIssueCategory, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIssueCategory(@PathVariable Long id){
        service.deleteIssueCategory(id);
    }

    @GetMapping("/{id}")
    public IssueCategoryEntity getIssueCategory(@PathVariable Long id){
        return service.getIssueCategory(id);
    }

}
