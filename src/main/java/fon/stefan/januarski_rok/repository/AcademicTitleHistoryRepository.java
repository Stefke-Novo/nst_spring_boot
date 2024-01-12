package fon.stefan.januarski_rok.repository;

import fon.stefan.januarski_rok.domain.AcademicTitle;
import fon.stefan.januarski_rok.domain.AcademicTitleHistory;
import fon.stefan.januarski_rok.domain.AcademicTitleHistoryId;
import fon.stefan.januarski_rok.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AcademicTitleHistoryRepository extends JpaRepository<AcademicTitleHistory, AcademicTitleHistoryId> {
    @Query("SELECT ath FROM AcademicTitleHistory WHERE ath.member.id=:memberId AND ath.member.pdepartment=:departmentId")
    Optional<List<AcademicTitleHistory>> findByDepartmentIdAndMemberId(@Param("departmentId") long departmentId, @Param("memberId") long memberId);
}
