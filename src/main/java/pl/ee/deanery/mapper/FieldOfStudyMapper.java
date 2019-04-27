package pl.ee.deanery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import pl.ee.deanery.dto.FieldOfStudyDTO;
import pl.ee.deanery.model.FieldOfStudyEntity;
import pl.ee.deanery.service.QueueService;

@Mapper(componentModel = "spring")
public abstract class FieldOfStudyMapper {

    @Autowired
    protected QueueService queueService;

    @Mapping(target="queueId", source="queueEntity.id")
    public abstract FieldOfStudyDTO toFieldOfStudyDTO(FieldOfStudyEntity entity);

    @Mapping(target = "queueEntity", expression = "java(queueService.getQueue(dto.getQueueId()))")
    public abstract FieldOfStudyEntity toFieldOfStudyEntity(FieldOfStudyDTO dto);

}
