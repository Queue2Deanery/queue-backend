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

    @PutMapping("/bind/{issueId}/queue/{queueId}")
    public void bindIssueToQueue(@PathVariable Long issueId, @PathVariable Long queueId){
        service.addToQueue(issueId, queueId);
    }

    @GetMapping("/{id}")
    public IssueEntity getIssue(@PathVariable Long id){
        return service.getIssue(id);
    }

    @PutMapping("/start/{id}")
    public IssueEntity startIssue(@PathVariable Long id){
        return service.startIssue(id);
    }

    @PutMapping("complete/{id}")
    public IssueEntity completeIssue(@PathVariable Long id){
        return service.completeIssue(id);
    }

}
