package pl.ee.deanery.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
    FieldOfStudyEntity - Nazwa wydziału
    np Eletrotechnika, AiR, Informatyka
    Zawiera nazwę oraz kolejkę, do której będą zapisywać się studenci danego wydziału
*/

@Data
//@Builder
@Entity
@RequiredArgsConstructor
public class FieldOfStudyEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @NotNull
  @Column(unique = true, nullable = false)
  private String name;

  @Column(unique = true)
  private String shortName;

  @ManyToOne
  @NotNull
  @JoinColumn(name = "queueID")
  private QueueEntity queueEntity;

}
