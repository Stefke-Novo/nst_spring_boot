package fon.stefan.januarski_rok.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fon.stefan.januarski_rok.converter.impl.AcademicTitleConverter;
import fon.stefan.januarski_rok.converter.impl.DepartmentConverter;
import fon.stefan.januarski_rok.converter.impl.ScientificFieldConverter;
import fon.stefan.januarski_rok.domain.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class MemberDto implements Serializable {

    @JsonProperty(value = "department",required = true)
    private DepartmentDto department;
    @JsonProperty(value = "id",required = true)
    private long id;
    @JsonProperty(value = "first_name",required = true)
    private String firstName;
    @JsonProperty(value = "last_name", required = true)
    private String lastName;

    @JsonProperty(value = "academic_title")
    private AcademicTitleDto academicTitle;

    @JsonProperty(value = "education_title")
    private EducationTitleDto educationTitle;

    @JsonProperty(value = "scientific_field")
    private ScientificFieldDto scientificField;


    public MemberDto(long id, String firstName, String lastName) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public MemberDto(Member member) {
        this.id=member.getId();
        this.firstName=member.getFirstName();
        this.lastName= member.getLastName();
        this.academicTitle = new AcademicTitleConverter().toDto(member.getAcademicTitles().get(member.getAcademicTitles().size()-1).getAcademicTitle());
        this.scientificField=new ScientificFieldConverter().toDto(member.getAcademicTitles().get(member.getAcademicTitles().size()-1).getScientificField());
        this.department=new DepartmentConverter().toDto(member.getDepartment());
        this.educationTitle= new EducationTitleConverter().toDto(member.getEducationTitle());
    }
}
