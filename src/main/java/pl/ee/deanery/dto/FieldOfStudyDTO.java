package pl.ee.deanery.dto;

import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
public class FieldOfStudyDTO {
    private Long id;
    private String name;
    private String shortName;
    private Long queueId;
}
