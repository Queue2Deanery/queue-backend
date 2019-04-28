package pl.ee.deanery.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/*
    QueueEntity - Kolejka
 */


@Builder
@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
public class QueueEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(unique = true, nullable = false)
  private String name;

  @Column(unique = true)
  private String shortName;

  @EqualsAndHashCode.Exclude
  //@JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "queueEntity")
  private List<IssueEntity> issueEntities;

  /*public Set<IssueEntity> addIssue(IssueEntity issueEntity) {
    issueEntity.setQueueEntity(this);
    issueEntities.add(issueEntity);
    return issueEntities;
  }*/


}
