package pl.ee.deanery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ee.deanery.model.IssueEntity;
import pl.ee.deanery.model.QueueEntity;
import pl.ee.deanery.repository.IssueRepository;
import pl.ee.deanery.repository.QueueRepository;

import java.util.List;

@Service
public class QueueService {

    @Autowired
    private QueueRepository repository;

    public Long addQueue(QueueEntity queue){
        return repository.save(queue).getId();
    }

    public List<QueueEntity> getAllQueues(){
        return repository.findAll();
    }

    public void deleteQueue(Long id){
        repository.deleteById(id);
    }

    public void editQueue(QueueEntity newQueue, Long id){
        repository.findById(id)
                .map(queue -> {
                    if(newQueue.getName() != null)
                        queue.setName(newQueue.getName());
                    if(newQueue.getShortName() != null)
                        queue.setShortName(newQueue.getShortName());
                    if(newQueue.getIssueEntities() != null)
                        queue.setIssueEntities(newQueue.getIssueEntities());
                    return repository.save(queue);
                }).orElseGet(() -> {
                    newQueue.setId(id);
                    return repository.save(newQueue);
                });
    }

    public QueueEntity getQueue(Long id){
        if(id == null)
            return null;
        return repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No Queue found with id: "+id));
    }

}
