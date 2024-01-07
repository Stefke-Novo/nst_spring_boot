package fon.stefan.januarski_rok.repository;

import fon.stefan.januarski_rok.domain.Department;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    <S extends Department> S save(S entity);


    //vrati department na osnovu imena
    Optional<Department> findByName(String name);
}
