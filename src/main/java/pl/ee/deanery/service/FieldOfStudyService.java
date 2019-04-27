package pl.ee.deanery.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ee.deanery.model.FieldOfStudyEntity;
import pl.ee.deanery.repository.FieldOfStudyRepository;

import java.util.List;

@Service
public class FieldOfStudyService {

    @Autowired
    private FieldOfStudyRepository repository;

    public void addFieldOfStudy(FieldOfStudyEntity fieldOfStudy){
        repository.save(fieldOfStudy);
    }

    public List<FieldOfStudyEntity> getAllFieldsOfStudy(){
        return repository.findAll();
    }

    public void editFieldOfStudy(FieldOfStudyEntity updatedEntity, Long id){
        repository.findById(id)
                .map(oldFieldOfStudy -> {

                    if(updatedEntity.getName() != null)
                        oldFieldOfStudy.setName(updatedEntity.getName());
                    if(updatedEntity.getShortName() != null)
                        oldFieldOfStudy.setShortName(updatedEntity.getShortName());
                    if(updatedEntity.getQueueEntity() != null)
                        oldFieldOfStudy.setQueueEntity(updatedEntity.getQueueEntity());

                    return repository.save(oldFieldOfStudy);
                }).orElseGet(() -> {
                    updatedEntity.setId(id);
                    return repository.save(updatedEntity);
                });
    }

    public void deleteFieldOfStudy(Long id){
        repository.deleteById(id);
    }

    public FieldOfStudyEntity getFieldOfStudy(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No FieldOfStudy found with id: "+id));
    }

}
