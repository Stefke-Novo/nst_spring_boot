package fon.stefan.januarski_rok.dto;

import fon.stefan.januarski_rok.converter.DtoEntityConverter;
import fon.stefan.januarski_rok.domain.EducationTitle;

public class EducationTitleConverter implements DtoEntityConverter<EducationTitleDto, EducationTitle> {
    @Override
    public EducationTitleDto toDto(EducationTitle educationTitle) {
        return new EducationTitleDto(educationTitle);
    }

    @Override
    public EducationTitle toEntity(EducationTitleDto educationTitleDto) {
        return null;
    }
}
