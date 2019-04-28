package pl.ee.deanery.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ee.deanery.model.IssueEntity;
import pl.ee.deanery.model.QueueEntity;
import pl.ee.deanery.repository.IssueRepository;
import pl.ee.deanery.repository.QueueRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    public Long addIssue(IssueEntity issue){
        /*queueRepository.findById(issue.getQueueEntity().getId())
                .ifPresentOrElse(queue -> queue.addIssue(issue),
                        // todo custom exception
                        ()->new IllegalArgumentException("Error while adding an Issue - no Queue with specified id"));
    */
        /*Long queueId = issue.getQueueEntity().getId();
        QueueEntity queue = queueRepository.findById(queueId)
                .orElseThrow(() -> new IllegalArgumentException("Queue not found >id: "+queueId));
        issue.setQueueEntity(queue);*/
        return issueRepository.save(issue).getId();
    }

    public List<IssueEntity> getAllIssues(){
        return issueRepository.findAll();
    }

    /*public void addToQueue(Long issueId, Long queueId){
        queueRepository.findById(queueId).ifPresentOrElse((queue ->
                        issueRepository.findById(issueId).ifPresentOrElse(issue ->
                                issue.setQueueEntity(queue),
                                () -> new IllegalArgumentException("Error while adding an Issue - no Issue with specified Id"))),
                ()->new IllegalArgumentException("Error while adding an Issue - no Queue with specified Id"));
    }*/

    public IssueEntity getIssue(Long id){
        if(id == null)
            return null;
        return issueRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Issue found with id: "+id));
    }

    public void deleteIssue(Long id){
        issueRepository.deleteById(id);
    }

    public void editIssue(IssueEntity newIssue, Long id){
        issueRepository.findById(id)
                .map(issue -> {
                    if(newIssue.getStudentComment() != null)
                        issue.setStudentComment(newIssue.getStudentComment());
                    if(newIssue.getStudentIndex() != null)
                        issue.setStudentIndex(newIssue.getStudentIndex());
                    return issueRepository.save(issue);
                }).orElseGet(() -> {
                    newIssue.setId(id);
                    return issueRepository.save(newIssue);
        });
    }

    public List<IssueEntity> getAllWaiting(){
        return issueRepository.findByCompletedAtIsNullOrderByCreatedAt();
    }

    public void startIssue(Long id){
        IssueEntity issue = getIssue(id);
        issue.setStartedAt(LocalDateTime.now());
        issueRepository.save(issue);
    }

    public void completeIssue(Long id){
        IssueEntity issue = getIssue(id);
        issue.setCompletedAt(LocalDateTime.now());
        issueRepository.save(issue);
    }



}
