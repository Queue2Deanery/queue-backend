package pl.ee.deanery.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
    IssueEntity - Sprawa do Dziekanatu
    Klasa opisująca studenta oczekującego w kolejce
 */

@Builder
@Data
@Entity
@RequiredArgsConstructor
//@NoArgsConstructor
@AllArgsConstructor
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

  /*@ManyToOne
  @JoinColumn(name = "fieldOfStudyID")
  private FieldOfStudyEntity fieldOfStudyEntity; // queueId już jednoznacznie łączy z fieldOfStudyId

*/
  @ManyToOne
  @JoinColumn(name = "queueID")
  private QueueEntity queueEntity;

  @ManyToOne
  @JoinColumn(name = "issueCategoryID")
  private IssueCategoryEntity issueCategoryEntity;

  @Column(nullable = false)
  private String studentIndex;

  @Column
  private String studentComment;

}
