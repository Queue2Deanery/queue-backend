package pl.ee.deanery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ee.deanery.model.IssueEntity;

@Repository
public interface IssueRepository extends JpaRepository<IssueEntity, Long> {
}
