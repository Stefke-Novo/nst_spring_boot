package fon.stefan.januarski_rok.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fon.stefan.januarski_rok.domain.EducationTitle;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationTitleDto {

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "education_title_id",required = true)
    private long id;

    public EducationTitleDto(EducationTitle educationTitle) {
        this.id=educationTitle.getId();
        this.title=educationTitle.getTitle();
    }
}
