package pl.ee.deanery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ee.deanery.dto.IssueDTO;
import pl.ee.deanery.mapper.IssueMapper;
import pl.ee.deanery.model.IssueEntity;
import pl.ee.deanery.service.IssueService;

import javax.net.ssl.HttpsURLConnection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    private IssueService service;

    @Autowired
    private IssueMapper mapper;

    @PostMapping("/new")
    public ResponseEntity<Map<String, Long>> newIssue(@RequestBody IssueDTO dto){
        Long id = service.addIssue(mapper.toIssueEntity(dto));
        return new ResponseEntity<>(Map.of("id", id), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<IssueDTO> listOfIssues(){
        return service.getAllIssues().stream()
                .map(issue -> mapper.toIssueDTO(issue))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public IssueDTO getIssue(@PathVariable Long id){
        return mapper.toIssueDTO(service.getIssue(id));
    }

    @GetMapping("/waiting")
    public List<IssueDTO> getAllIssuesWaiting(){
        return service.getAllWaiting().stream()
                .map(issue -> mapper.toIssueDTO(issue))
                .collect(Collectors.toList());
    }

    @PutMapping("/start/{id}")
    public ResponseEntity startIssue(@PathVariable Long id){
        service.startIssue(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("complete/{id}")
    public ResponseEntity completeIssue(@PathVariable Long id){
        service.completeIssue(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
