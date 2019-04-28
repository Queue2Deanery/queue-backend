package pl.ee.deanery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ee.deanery.dto.QueueDTO;
import pl.ee.deanery.mapper.QueueMapper;
import pl.ee.deanery.model.QueueEntity;
import pl.ee.deanery.service.QueueService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    private QueueService service;

    @Autowired
    private QueueMapper mapper;

    @PostMapping("/new")
    public ResponseEntity<Map<String, Long>> newQueue(@RequestBody QueueEntity entity){
        Long id = service.addQueue(entity);
        return new ResponseEntity<>(Map.of("id", id), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<QueueDTO> listOfQueues(){
        return service.getAllQueues().stream()
                .map(queue -> mapper.toQueueDTO(queue))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public QueueDTO getQueue(@PathVariable Long id){
        return mapper.toQueueDTO(service.getQueue(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editQueue(@RequestBody QueueDTO newQueue,
                                                 @PathVariable Long id){
        service.editQueue(mapper.toQueueEntity(newQueue), id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteQueue(@PathVariable Long id){
        service.deleteQueue(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
