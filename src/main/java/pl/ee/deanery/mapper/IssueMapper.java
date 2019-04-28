package pl.ee.deanery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import pl.ee.deanery.dto.FieldOfStudyDTO;
import pl.ee.deanery.dto.IssueDTO;
import pl.ee.deanery.dto.QueueDTO;
import pl.ee.deanery.model.IssueEntity;
import pl.ee.deanery.service.FieldOfStudyService;
import pl.ee.deanery.service.IssueCategoryService;
import pl.ee.deanery.service.QueueService;


@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class IssueMapper {

    //@Autowired
    //protected FieldOfStudyService fieldOfStudyService;

    @Autowired
    protected IssueCategoryService issueCategoryService;

    @Autowired
    protected QueueService queueService;

    //@Mapping(target="fieldOfStudyEntity",
    //        expression = "java(fieldOfStudyService.getFieldOfStudy(dto.getFieldOfStudyId()))")
    @Mapping(target="issueCategoryEntity",
            expression = "java(issueCategoryService.getIssueCategory(dto.getIssueCategoryId()))")
    @Mapping(target="queueEntity", expression = "java(queueService.getQueue(dto.getQueueId()))")
    public abstract IssueEntity toIssueEntity(IssueDTO dto);

    //@Mapping(target="fieldOfStudyId", source = "fieldOfStudyEntity.id")
    @Mapping(target="issueCategoryId", source = "issueCategoryEntity.id")
    @Mapping(target="queueId", source = "queueEntity.id")
    public abstract IssueDTO toIssueDTO(IssueEntity entity);

}
