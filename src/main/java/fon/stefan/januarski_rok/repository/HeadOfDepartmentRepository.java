package fon.stefan.januarski_rok.repository;

import fon.stefan.januarski_rok.domain.HeadOfDepartment;
import fon.stefan.januarski_rok.domain.HeadOfDepartmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HeadOfDepartmentRepository extends JpaRepository<HeadOfDepartment, HeadOfDepartmentId> {
    @Query("SELECT hod FROM HeadOfDepartment hod WHERE hod.member.department.id=:departmentId")
    Optional<List<HeadOfDepartment>> findByDepartmentId(@Param("departmentId") long id);
}
