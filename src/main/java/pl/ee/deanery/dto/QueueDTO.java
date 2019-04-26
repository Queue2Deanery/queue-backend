package pl.ee.deanery.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
public class QueueDTO {
    private Long id;
    private String name;
    private String shortName;
    private List<Long> issuesIds;
}
