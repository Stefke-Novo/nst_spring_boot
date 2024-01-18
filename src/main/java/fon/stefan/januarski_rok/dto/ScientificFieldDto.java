package fon.stefan.januarski_rok.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fon.stefan.januarski_rok.domain.ScientificField;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScientificFieldDto {

    @JsonProperty(value = "scientific_field_id",required = true)
    private long id;

    @JsonProperty(value = "name")
    private String name;

    public ScientificFieldDto(ScientificField scientificField) {
        this.id=scientificField.getId();
        this.name=scientificField.getName();
    }
}
