package fon.stefan.januarski_rok.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fon.stefan.januarski_rok.converter.impl.DepartmentConverter;
import fon.stefan.januarski_rok.converter.impl.MemberConverter;
import fon.stefan.januarski_rok.domain.HeadOfDepartment;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeadOfDepartmentDto {

    @JsonProperty(value = "department", required = true)
    private DepartmentDto department;

    @JsonProperty(value = "member", required = true)
    private MemberDto member;

    @JsonProperty(value = "head_of_department_id", required = true)
    private long id;

    public HeadOfDepartmentDto(HeadOfDepartment headOfDepartment) {
        this.id=headOfDepartment.getId();
        this.department= new DepartmentConverter().toDto(headOfDepartment.getDepartment());
        this.member=new MemberConverter().toDto(headOfDepartment.getMember());
    }
}
