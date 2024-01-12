package fon.stefan.januarski_rok.repository;

import fon.stefan.januarski_rok.domain.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void save() {
        Department department = new Department();
        department.setName("Department 6");
        department = departmentRepository.save(department);
        System.out.println(department.toString());
    }
}