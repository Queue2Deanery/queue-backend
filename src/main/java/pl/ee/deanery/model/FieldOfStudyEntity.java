package pl.ee.deanery.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
public class FieldOfStudyEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(unique = true, nullable = false)
  private String name;

  @Column(unique = true)
  private String shortName;

  @ManyToOne
  private QueueEntity queueEntity;

}
