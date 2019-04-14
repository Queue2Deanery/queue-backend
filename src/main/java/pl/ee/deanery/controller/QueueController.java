package pl.ee.deanery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ee.deanery.model.QueueEntity;
import pl.ee.deanery.repository.QueueRepository;
import pl.ee.deanery.service.QueueService;

import java.util.List;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    private QueueService service;

    @GetMapping("/list")
    public List<QueueEntity> listOfQueues(){
        return service.getAllQueues();
    }

    @PostMapping("/new")
    public QueueEntity newQueue(@RequestBody QueueEntity entity){
        return service.addQueue(entity);
    }

    @PutMapping("/edit/{id}")
    public QueueEntity editQueue(@RequestBody QueueEntity newQueue,
                                                 @PathVariable Long id){
        return service.editQueue(newQueue, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQueue(@PathVariable Long id){
        service.deleteQueue(id);
    }
}
