package pl.ee.deanery.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/*
    QueueEntity - Kolejka
 */


//@Builder
@Data
@Entity
@RequiredArgsConstructor
public class QueueEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(unique = true, nullable = false)
  private String name;

  @Column(unique = true)
  private String shortName;

  @EqualsAndHashCode.Exclude
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "queueEntity")
  private Set<IssueEntity> issueEntities;

  /*public Set<IssueEntity> addIssue(IssueEntity issueEntity) {
    issueEntity.setQueueEntity(this);
    issueEntities.add(issueEntity);
    return issueEntities;
  }*/


}
