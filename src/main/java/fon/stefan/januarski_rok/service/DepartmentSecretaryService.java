package fon.stefan.januarski_rok.service;

import fon.stefan.januarski_rok.domain.DepartmentSecretary;
import fon.stefan.januarski_rok.dto.DepartmentDto;
import fon.stefan.januarski_rok.dto.DepartmentSecretaryDto;
import fon.stefan.januarski_rok.dto.MemberDto;

import java.util.List;

public interface DepartmentSecretaryService {
    List<DepartmentSecretaryDto> getAllDepartmentSecretaries();
    DepartmentSecretaryDto deleteDepartmentSecretary(DepartmentSecretaryDto departmentSecretary) throws Exception;
    DepartmentSecretaryDto currentDepartmentSecretary(DepartmentDto departmentDto) throws Exception;
    List<DepartmentSecretaryDto> getDepartmentSecretaryHistory(DepartmentDto departmentDto)throws Exception;
    DepartmentSecretaryDto createDepartemntSecretary(DepartmentSecretaryDto departmentSecretaryDto) throws  Exception;
}
