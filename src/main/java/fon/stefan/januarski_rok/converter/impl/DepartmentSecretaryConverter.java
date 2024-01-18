package fon.stefan.januarski_rok.converter.impl;

import fon.stefan.januarski_rok.converter.DtoEntityConverter;
import fon.stefan.januarski_rok.domain.DepartmentSecretary;
import fon.stefan.januarski_rok.dto.DepartmentSecretaryDto;

public class DepartmentSecretaryConverter implements DtoEntityConverter<DepartmentSecretaryDto,DepartmentSecretary> {
    @Override
    public DepartmentSecretaryDto toDto(DepartmentSecretary departmentSecretary) {
        return new DepartmentSecretaryDto(departmentSecretary);
    }

    @Override
    public DepartmentSecretary toEntity(DepartmentSecretaryDto departmentSecretaryDto) {
        return null;
    }
}
