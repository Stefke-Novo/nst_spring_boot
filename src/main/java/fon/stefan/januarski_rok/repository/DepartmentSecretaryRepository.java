package fon.stefan.januarski_rok.repository;

import fon.stefan.januarski_rok.domain.DepartmentSecretary;
import fon.stefan.januarski_rok.domain.DepartmentSecretaryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentSecretaryRepository extends JpaRepository<DepartmentSecretary, DepartmentSecretaryId> {
}
