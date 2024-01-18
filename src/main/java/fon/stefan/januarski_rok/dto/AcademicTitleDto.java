package fon.stefan.januarski_rok.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fon.stefan.januarski_rok.domain.AcademicTitle;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicTitleDto {

    @JsonProperty(value = "academic_title_id", required = true)
    private long id;

    @JsonProperty(value = "title")
    private String title;

    public AcademicTitleDto(AcademicTitle academicTitle) {
        this.id=academicTitle.getId();
        this.title=academicTitle.getTitle();
    }
}
