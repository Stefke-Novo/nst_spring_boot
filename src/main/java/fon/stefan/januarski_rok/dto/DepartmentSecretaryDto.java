package fon.stefan.januarski_rok.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fon.stefan.januarski_rok.converter.impl.DepartmentConverter;
import fon.stefan.januarski_rok.converter.impl.MemberConverter;
import fon.stefan.januarski_rok.domain.DepartmentSecretary;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentSecretaryDto implements Serializable {

    @JsonProperty(value = "department",required = true)
    private DepartmentDto departmentDto;

    @JsonProperty(value = "member",required = true)
    private MemberDto memberDto;

    @JsonProperty(value = "id",required = true)
    private long id;

    public DepartmentSecretaryDto(DepartmentSecretary departmentSecretary) {
        this.id=departmentSecretary.getId();
        this.departmentDto=new DepartmentConverter().toDto(departmentSecretary.getDepartment());
        this.memberDto=new MemberConverter().toDto(departmentSecretary.getMember());
    }
}
