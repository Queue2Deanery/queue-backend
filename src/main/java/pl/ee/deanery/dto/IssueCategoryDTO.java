package pl.ee.deanery.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
public class IssueCategoryDTO {
    private Long id;
    private String name;
    private List<Long> issueEntitiesIds;
}
