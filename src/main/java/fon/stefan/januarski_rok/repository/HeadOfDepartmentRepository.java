package fon.stefan.januarski_rok.repository;

import fon.stefan.januarski_rok.domain.HeadOfDepartment;
import fon.stefan.januarski_rok.domain.HeadOfDepartmentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeadOfDepartmentRepository extends JpaRepository<HeadOfDepartment, HeadOfDepartmentId> {
}
