package fon.stefan.januarski_rok.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fon.stefan.januarski_rok.converter.impl.DepartmentConverter;
import fon.stefan.januarski_rok.domain.Subject;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto implements Serializable {

    private long id;

    private String name;

    private int espb;

    @JsonProperty(value = "department")
    private DepartmentDto departmentDto;

    public SubjectDto(Subject entity) {
        this.id=entity.getId();
        this.name=entity.getName();
        this.espb=entity.getEspb();
        this.departmentDto=new DepartmentConverter().toDto(entity.getDepartment());
    }
}
