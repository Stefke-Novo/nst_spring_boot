package fon.stefan.januarski_rok.converter.impl;

import fon.stefan.januarski_rok.converter.DtoEntityConverter;
import fon.stefan.januarski_rok.domain.Department;
import fon.stefan.januarski_rok.dto.DepartmentDto;

public class DepartmentConverter implements DtoEntityConverter<DepartmentDto,Department> {
    @Override
    public DepartmentDto toDto(Department entity) {
        return new DepartmentDto(entity.getId(),entity.getName(),entity.getShortName());
    }

    @Override
    public Department toEntity(DepartmentDto dto) {
        return new Department(dto.getId(), dto.getName(), dto.getShortName());
    }
}
