package fon.stefan.januarski_rok.repository;

import fon.stefan.januarski_rok.domain.AcademicTitleHistory;
import fon.stefan.januarski_rok.domain.AcademicTitleHistoryId;
import fon.stefan.januarski_rok.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcademicTitleHistoryRepository extends JpaRepository<AcademicTitleHistory, AcademicTitleHistoryId> {
}
