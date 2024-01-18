package fon.stefan.januarski_rok.converter.impl;

import fon.stefan.januarski_rok.converter.DtoEntityConverter;
import fon.stefan.januarski_rok.domain.AcademicTitle;
import fon.stefan.januarski_rok.dto.AcademicTitleDto;

public class AcademicTitleConverter implements DtoEntityConverter<AcademicTitleDto, AcademicTitle> {
    @Override
    public AcademicTitleDto toDto(AcademicTitle academicTitle) {
        return new AcademicTitleDto(academicTitle);
    }

    @Override
    public AcademicTitle toEntity(AcademicTitleDto academicTitleDto) {
        return new AcademicTitle(academicTitleDto);
    }
}
