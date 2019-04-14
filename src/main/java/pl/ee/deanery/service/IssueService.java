package pl.ee.deanery.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ee.deanery.model.IssueEntity;
import pl.ee.deanery.repository.IssueRepository;
import pl.ee.deanery.repository.QueueRepository;

import java.util.List;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private QueueRepository queueRepository;

    public IssueEntity addIssue(IssueEntity issue){
        queueRepository.findById(issue.getQueueEntity().getId())
                .ifPresent(queue -> queue.addIssue(issue));
        return issueRepository.save(issue);
    }

    public List<IssueEntity> getAllIssues(){
        return issueRepository.findAll();
    }
}
