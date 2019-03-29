package pl.ee.deanery.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ee.deanery.model.IssueEntity;
import pl.ee.deanery.repository.IssueRepository;

import java.util.List;

@Service
public class IssueService {

    @Autowired
    private IssueRepository repository;

    public IssueEntity addIssue(IssueEntity issue){
        return repository.save(issue);
    }

    public List<IssueEntity> getAllIssues(){
        return repository.findAll();
    }
}
