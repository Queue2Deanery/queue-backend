package pl.ee.deanery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ee.deanery.model.IssueEntity;
import pl.ee.deanery.repository.IssueRepository;

import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    private IssueRepository repository;

    @GetMapping("/list")
    public List<IssueEntity> listOfIssues(){
        return repository.findAll();
    }

    @PostMapping("/new")
    public IssueEntity newIssue(@RequestBody IssueEntity entity){
        return repository.save(entity);
    }


}
