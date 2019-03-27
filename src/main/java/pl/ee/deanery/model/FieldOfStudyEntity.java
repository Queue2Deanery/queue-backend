package pl.ee.deanery.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/*
    FieldOfStudyEntity - Nazwa wydziału
    np Eletrotechnika, AiR, Informatyka
    Zawiera nazwę oraz kolejkę, do której będą zapisywać się studenci danego wydziału
*/

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
