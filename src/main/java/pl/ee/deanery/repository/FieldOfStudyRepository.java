package pl.ee.deanery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ee.deanery.model.FieldOfStudyEntity;

@Repository
public interface FieldOfStudyRepository extends JpaRepository<FieldOfStudyEntity, Long> {
}
