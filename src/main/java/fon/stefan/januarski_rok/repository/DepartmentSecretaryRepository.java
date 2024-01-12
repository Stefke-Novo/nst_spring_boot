package fon.stefan.januarski_rok.repository;

import fon.stefan.januarski_rok.domain.DepartmentSecretary;
import fon.stefan.januarski_rok.domain.DepartmentSecretaryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DepartmentSecretaryRepository extends JpaRepository<DepartmentSecretary, DepartmentSecretaryId> {
    @Query("SELECT ds FROM DepartmentSecretary ds WHERE ds.member.pdepartment.id=:departmentId")
    Optional<List<DepartmentSecretary>> findByDepartmentId( @Param("departmentId") long departmentId);
}
