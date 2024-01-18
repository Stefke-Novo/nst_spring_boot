package fon.stefan.januarski_rok.converter.impl;

import fon.stefan.januarski_rok.converter.DtoEntityConverter;
import fon.stefan.januarski_rok.domain.Subject;
import fon.stefan.januarski_rok.dto.SubjectDto;
import org.springframework.beans.factory.annotation.Autowired;

public class SubjectConverter implements DtoEntityConverter<SubjectDto, Subject> {
    @Autowired
    private DepartmentConverter departmentConverter;

    @Override
    public SubjectDto toDto(Subject entity) {
        return new SubjectDto(entity);
    }

    @Override
    public Subject toEntity(SubjectDto dto) {
        return new Subject(dto);
    }
}
