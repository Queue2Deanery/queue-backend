package pl.ee.deanery.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ee.deanery.model.IssueCategoryEntity;
import pl.ee.deanery.repository.IssueCategoryRepository;

import java.util.List;

@Service
public class IssueCategoryService {

    @Autowired
    private IssueCategoryRepository repository;

    public IssueCategoryEntity addIssueCategory(IssueCategoryEntity issueCategory){
        return repository.save(issueCategory);
    }

    public List<IssueCategoryEntity> getAllIssueCategories(){
        return repository.findAll();
    }
}
