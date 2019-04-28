package pl.ee.deanery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ee.deanery.model.IssueEntity;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<IssueEntity, Long> {
    IssueEntity findByQueueEntityId(Long id);
    List<IssueEntity> findByCompletedAtIsNullOrderByCreatedAt();
}
