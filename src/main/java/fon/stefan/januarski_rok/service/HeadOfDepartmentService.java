package fon.stefan.januarski_rok.service;

import fon.stefan.januarski_rok.domain.HeadOfDepartment;
import fon.stefan.januarski_rok.dto.DepartmentDto;
import fon.stefan.januarski_rok.dto.HeadOfDepartmentDto;
import fon.stefan.januarski_rok.dto.MemberDto;

import java.util.List;

public interface HeadOfDepartmentService {
    HeadOfDepartmentDto getCurrentHeadOfDepartment(DepartmentDto departmentDto) throws Exception;
    List<HeadOfDepartmentDto> getAllHadOfDepartments();
    List<HeadOfDepartmentDto> getHeadOfDepartmentHistory(DepartmentDto departmentDto) throws Exception;
    HeadOfDepartmentDto createHeadOfDepartment(HeadOfDepartmentDto headOfDepartmentDto) throws Exception;
    HeadOfDepartmentDto deleteHeadOfDepartment(HeadOfDepartmentDto headOfDepartmentDto) throws Exception;
}
