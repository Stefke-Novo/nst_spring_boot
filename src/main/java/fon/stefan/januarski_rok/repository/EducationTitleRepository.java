package fon.stefan.januarski_rok.repository;

import fon.stefan.januarski_rok.domain.EducationTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EducationTitleRepository extends JpaRepository<EducationTitle,Long> {
    Optional<EducationTitle> findByTitle(String title);
}
