package pl.ee.deanery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ee.deanery.dto.FieldOfStudyDTO;
import pl.ee.deanery.mapper.FieldOfStudyMapper;
import pl.ee.deanery.service.FieldOfStudyService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/field-of-study")
public class FieldOfStudyController {

    @Autowired
    private FieldOfStudyService service;

    @Autowired
    private FieldOfStudyMapper mapper;

    @GetMapping("/list")
    public List<FieldOfStudyDTO> listOfFieldsOfStudy(){

        return service.getAllFieldsOfStudy().stream()
                .map(entity -> mapper.toFieldOfStudyDTO(entity))
                .collect(Collectors.toList());
    }

    @PostMapping("/new")
    public ResponseEntity newFieldOfStudy(@RequestBody FieldOfStudyDTO dto){
        service.addFieldOfStudy(mapper.toFieldOfStudyEntity(dto));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editFieldOfStudy(@RequestBody FieldOfStudyDTO dto, @PathVariable Long id){
        service.editFieldOfStudy(mapper.toFieldOfStudyEntity(dto), id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFieldOfStudy(@PathVariable Long id){
        service.deleteFieldOfStudy(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public FieldOfStudyDTO getFieldOfStudy(@PathVariable Long id){
        return mapper.toFieldOfStudyDTO(service.getFieldOfStudy(id));
    }

}
