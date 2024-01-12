package fon.stefan.januarski_rok.service;

import fon.stefan.januarski_rok.dto.DepartmentDto;
import fon.stefan.januarski_rok.dto.DepartmentSecretaryDto;

import java.util.List;

public interface DepartmentSecretaryService {
    List<DepartmentSecretaryDto> getAllDepartmentSecretaries();
    DepartmentSecretaryDto deleteDepartmentSecretary(DepartmentSecretaryDto departmentSecretary) throws Exception;
    DepartmentSecretaryDto currentDepartmentSecretary(DepartmentDto departmentDto) throws Exception;
    List<DepartmentSecretaryDto> getDepartmentSecretaryHistory(DepartmentDto departmentDto)throws Exception;
    DepartmentSecretaryDto createDepartmentSecretary(DepartmentSecretaryDto departmentSecretaryDto) throws  Exception;
}
