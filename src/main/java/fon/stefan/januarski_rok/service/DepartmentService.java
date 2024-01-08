package fon.stefan.januarski_rok.service;

import fon.stefan.januarski_rok.domain.Member;
import fon.stefan.januarski_rok.dto.DepartmentDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> getAll(Pageable pageable);
    List<DepartmentDto> getAll();

    DepartmentDto save(DepartmentDto departmentDto) throws Exception;

    void delete(Long id) throws Exception;
    void update(DepartmentDto department) throws Exception;
    DepartmentDto findById(Long id) throws Exception;

    DepartmentDto getDepartmentWithMembers(Long id) throws Exception;
}
