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

    public Long addIssueCategory(IssueCategoryEntity issueCategory){
        return repository.save(issueCategory).getId();
    }

    public List<IssueCategoryEntity> getAllIssueCategories(){
        return repository.findAll();
    }

    public void deleteIssueCategory(Long id){
        repository.deleteById(id);
    }

    public void editIssueCategory(IssueCategoryEntity newIssueCategory, Long id){
        repository.findById(id)
                .map(issueCategory -> {
                    if(newIssueCategory.getName() != null)
                        issueCategory.setName(newIssueCategory.getName());
                    if(newIssueCategory.getIssueEntities() != null)
                        issueCategory.setIssueEntities(newIssueCategory.getIssueEntities());
                    return repository.save(issueCategory);
                }).orElseGet(() -> {
                    newIssueCategory.setId(id);
                    return repository.save(newIssueCategory);
                });
    }

    public IssueCategoryEntity getIssueCategory(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No IssueCategory found with id: "+id));
    }
}
