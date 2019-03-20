package pl.ee.deanery.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@Entity
public class IssueEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Builder.Default
  @Column
  private  LocalDateTime createdAt = LocalDateTime.now();

  @Column
  private LocalDateTime startedAt;

  @Column
  private LocalDateTime completedAt;

  @ManyToOne
  private FieldOfStudyEntity fieldOfStudyEntity;

  @ManyToOne
  private QueueEntity queueEntity;

  @ManyToOne
  private IssueCategoryEntity issueCategoryEntity;

  @Column(nullable = false)
  private String studentIndex;

  @Column
  private String studentComment;

}
