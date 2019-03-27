package pl.ee.deanery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ee.deanery.model.QueueEntity;
import pl.ee.deanery.repository.QueueRepository;

import java.util.List;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    private QueueRepository repository;

    @GetMapping("/list")
    public List<QueueEntity> listOfQueues(){
        return repository.findAll();
    }

    @PostMapping("/new")
    public QueueEntity newQueue(@RequestBody QueueEntity entity){
        return repository.save(entity);
    }

}
