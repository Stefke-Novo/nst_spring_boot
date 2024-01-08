package fon.stefan.januarski_rok.repository;

import fon.stefan.januarski_rok.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
