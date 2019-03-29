package pl.ee.deanery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ee.deanery.model.IssueEntity;
import pl.ee.deanery.service.IssueService;

import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    private IssueService service;

    @GetMapping("/list")
    public List<IssueEntity> listOfIssues(){
        return service.getAllIssues();
    }

    @PostMapping("/new")
    public IssueEntity newIssue(@RequestBody IssueEntity entity){
        return service.addIssue(entity);
    }


}
