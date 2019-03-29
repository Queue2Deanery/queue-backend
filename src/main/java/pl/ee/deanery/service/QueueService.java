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

}
