package pl.ee.deanery.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
public class IssueDTO {
    private Long id;
    private  LocalDateTime createdAt;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private Long fieldOfStudyEntityId;
    private Long queueEntityId;
    private Long issueCategoryEntityId;
    private String studentIndex;
    private String studentComment;
}
