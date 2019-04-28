package pl.ee.deanery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import pl.ee.deanery.dto.QueueDTO;
import pl.ee.deanery.model.IssueEntity;
import pl.ee.deanery.model.QueueEntity;
import pl.ee.deanery.service.IssueService;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class QueueMapper {

    @Autowired
    protected IssueService issueService;

    @Mapping(target="issueEntities", //expression = "java(mapIdsToEntitiesList(dto.getIssueIds()))")
            ignore = true)
    public abstract QueueEntity toQueueEntity(QueueDTO dto);

    //@Mapping(target="issueIds", expression = "java(mapEntitiesToIdsList(entity.getIssueEntities()))")
    public abstract QueueDTO toQueueDTO(QueueEntity entity);

    protected List<IssueEntity> mapIdsToEntitiesList(List<Long> idsList){
        return idsList.stream()
                .map(issueId -> issueService.getIssue(issueId))
                .collect(Collectors.toList());
    }

    protected List<Long> mapEntitiesToIdsList(List<IssueEntity> entitiesList){
        return entitiesList.stream()
                .map(entity -> entity.getId())
                .collect(Collectors.toList());
    }
}
