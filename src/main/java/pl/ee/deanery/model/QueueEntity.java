package pl.ee.deanery.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Builder
@Data
@Entity
public class QueueEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(unique = true, nullable = false)
  private String name;

  @Column(unique = true)
  private String shortName;

  @EqualsAndHashCode.Exclude
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "queueEntity")
  private Set<IssueEntity> issueEntities;

  public Set<IssueEntity> addIssue(IssueEntity issueEntity) {
    issueEntity.setQueueEntity(this);
    issueEntities.add(issueEntity);
    return issueEntities;
  }

}
