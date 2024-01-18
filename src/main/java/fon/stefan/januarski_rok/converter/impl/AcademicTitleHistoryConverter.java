package fon.stefan.januarski_rok.converter.impl;

import fon.stefan.januarski_rok.converter.DtoEntityConverter;
import fon.stefan.januarski_rok.domain.AcademicTitleHistory;
import fon.stefan.januarski_rok.domain.ScientificField;
import fon.stefan.januarski_rok.dto.AcademicTitleHistoryDto;

public class AcademicTitleHistoryConverter implements DtoEntityConverter<AcademicTitleHistoryDto, AcademicTitleHistory> {
    @Override
    public AcademicTitleHistoryDto toDto(AcademicTitleHistory academicTitleHistory) {
        return new AcademicTitleHistoryDto(academicTitleHistory);
    }

    @Override
    public AcademicTitleHistory toEntity(AcademicTitleHistoryDto academicTitleHistoryDto) {
        return new AcademicTitleHistory(academicTitleHistoryDto);
    }
}
