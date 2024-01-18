package fon.stefan.januarski_rok.converter.impl;

import fon.stefan.januarski_rok.converter.DtoEntityConverter;
import fon.stefan.januarski_rok.domain.ScientificField;
import fon.stefan.januarski_rok.dto.ScientificFieldDto;

public class ScientificFieldConverter implements DtoEntityConverter<ScientificFieldDto, ScientificField> {
    @Override
    public ScientificFieldDto toDto(ScientificField scientificField) {
        return new ScientificFieldDto(scientificField);
    }

    @Override
    public ScientificField toEntity(ScientificFieldDto scientificFieldDto) {
        return null;
    }
}
