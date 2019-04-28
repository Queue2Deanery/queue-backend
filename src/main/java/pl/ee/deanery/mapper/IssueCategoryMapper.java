package pl.ee.deanery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.ee.deanery.dto.IssueCategoryDTO;
import pl.ee.deanery.model.IssueCategoryEntity;

@Mapper(componentModel = "spring")
public abstract class IssueCategoryMapper {


    public abstract IssueCategoryDTO toIssueCategoryDTO(IssueCategoryEntity entity);

    @Mapping(target = "issueEntities", ignore = true)
    public abstract IssueCategoryEntity toIssueCategoryEntity(IssueCategoryDTO dto);

}
