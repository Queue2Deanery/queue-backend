package pl.ee.deanery.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Builder
@Data
@Entity
public class IssueCategoryEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(unique = true, nullable = false)
  private String name;

  @EqualsAndHashCode.Exclude
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "issueCategoryEntity")
  Set<IssueEntity> issueEntities;

  public Set<IssueEntity> addIssue(IssueEntity issueEntity) {
    issueEntity.setIssueCategoryEntity(this);
    issueEntities.add(issueEntity);
    return issueEntities;
  }

}
