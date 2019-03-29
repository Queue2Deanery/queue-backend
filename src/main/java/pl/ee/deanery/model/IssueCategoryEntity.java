package pl.ee.deanery.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/*
    IssueCategoryEntity - Kategoria sprawy
    Kategoria sprawy wybierana przez każdego oczekującego w kolejce
    Różne kategorie będą definiowane przez Dziekanat
 */

//@Builder
@Data
@Entity
@RequiredArgsConstructor
public class IssueCategoryEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(unique = true, nullable = false)
  private String name;
/*
  @EqualsAndHashCode.Exclude
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "issueCategoryEntity")
  private Set<IssueEntity> issueEntities;

  public Set<IssueEntity> addIssue(IssueEntity issueEntity) {
    issueEntity.setIssueCategoryEntity(this);
    issueEntities.add(issueEntity);
    return issueEntities;
  }*/

}
