package pl.ee.deanery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ee.deanery.dto.IssueCategoryDTO;
import pl.ee.deanery.mapper.IssueCategoryMapper;
import pl.ee.deanery.model.IssueCategoryEntity;
import pl.ee.deanery.repository.IssueCategoryRepository;
import pl.ee.deanery.service.IssueCategoryService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/issue-category")
public class IssueCategoryController {

    @Autowired
    private IssueCategoryService service;

    @Autowired
    private IssueCategoryMapper mapper;

    @GetMapping("/list")
    public List<IssueCategoryDTO> listOfIssueCategories(){
        return service.getAllIssueCategories().stream()
                .map(issueCategory -> mapper.toIssueCategoryDTO(issueCategory))
                .collect(Collectors.toList());
    }

    @PostMapping("/new")
    public ResponseEntity<Map<String, Long>> newIssueCategory(@RequestBody IssueCategoryDTO dto){
        Long id = service.addIssueCategory(mapper.toIssueCategoryEntity(dto));
        return new ResponseEntity<>(Map.of("id", id), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editIssueCategory(@RequestBody IssueCategoryDTO dto,
                                                 @PathVariable Long id){
       service.editIssueCategory(mapper.toIssueCategoryEntity(dto), id);
       return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteIssueCategory(@PathVariable Long id){
        service.deleteIssueCategory(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public IssueCategoryDTO getIssueCategory(@PathVariable Long id){
        return mapper.toIssueCategoryDTO(service.getIssueCategory(id));
    }



}
