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

    public QueueEntity addQueue(QueueEntity queue){
        return repository.save(queue);
    }

    public List<QueueEntity> getAllQueues(){
        return repository.findAll();
    }

    public void deleteQueue(Long id){
        repository.deleteById(id);
    }

    public QueueEntity editQueue(QueueEntity newQueue, Long id){
        return repository.findById(id)
                .map(queue -> {
                    queue.setName(newQueue.getName());
                    queue.setShortName(newQueue.getShortName());
                    return repository.save(queue);
                }).orElseGet(() -> {
                    newQueue.setId(id);
                    return repository.save(newQueue);
                });
    }

    public QueueEntity getQueueById(Long id){
        return repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Queue not found >id"+id));
    }

}
