package fon.stefan.januarski_rok.converter.impl;

import fon.stefan.januarski_rok.converter.DtoEntityConverter;
import fon.stefan.januarski_rok.domain.HeadOfDepartment;
import fon.stefan.januarski_rok.dto.HeadOfDepartmentDto;

public class HeadOfDepartmentConverter implements DtoEntityConverter<HeadOfDepartmentDto, HeadOfDepartment> {
    @Override
    public HeadOfDepartmentDto toDto(HeadOfDepartment headOfDepartment) {
        return new HeadOfDepartmentDto(headOfDepartment);
    }

    @Override
    public HeadOfDepartment toEntity(HeadOfDepartmentDto headOfDepartmentDto) {
        return null;
    }
}
