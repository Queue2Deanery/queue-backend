package pl.ee.deanery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ee.deanery.model.QueueEntity;

import java.util.Optional;

@Repository
public interface QueueRepository extends JpaRepository<QueueEntity, Long> {
}
