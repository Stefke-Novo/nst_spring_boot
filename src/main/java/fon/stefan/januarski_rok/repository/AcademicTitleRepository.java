package fon.stefan.januarski_rok.repository;

import fon.stefan.januarski_rok.domain.AcademicTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcademicTitleRepository extends JpaRepository<AcademicTitle,Long> {
    Optional<AcademicTitle> findByTitle(String title);
}
