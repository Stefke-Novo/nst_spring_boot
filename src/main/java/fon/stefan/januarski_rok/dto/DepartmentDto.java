package fon.stefan.januarski_rok.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fon.stefan.januarski_rok.converter.impl.MemberConverter;
import fon.stefan.januarski_rok.domain.Department;
import fon.stefan.januarski_rok.domain.Member;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto implements Serializable {

    @JsonProperty(value = "department_id", required = true)
    private long id;

    @NotNull
    @Size(min = 2,max = 10, message = "Broj znakova [2-10]")
    @JsonProperty(required = true)
    private String name;

    private List<MemberDto> members;

    @JsonProperty(value = "short_name")
    private String shortName;

    public DepartmentDto(Long id, String name, String shortName) {
        this.id=id;
        this.name=name;
        this.shortName=shortName;
    }
}
