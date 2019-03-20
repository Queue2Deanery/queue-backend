package pl.ee.deanery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ee.deanery.model.IssueCategoryEntity;

@Repository
public interface IssueCategoryRepository extends JpaRepository<IssueCategoryEntity, Long> {
}
