package fon.stefan.januarski_rok.repository;

import fon.stefan.januarski_rok.domain.ScientificField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScientificFieldRepository extends JpaRepository<ScientificField,Long> {
    Optional<ScientificField> findByName(String name);
}
