package fon.stefan.januarski_rok.dto;

import fon.stefan.januarski_rok.converter.impl.MemberConverter;
import fon.stefan.januarski_rok.domain.Department;
import fon.stefan.januarski_rok.domain.Member;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

public class DepartmentDto implements Serializable {
    private long id;

    @NotNull
    @Size(min = 2,max = 10, message = "Broj znakova [2-10]")
    private String name;

    private List<MemberDto> members;
    public DepartmentDto(){
    }

    public DepartmentDto(long id, String name){
        this.id=id;
        this.name=name;
    }
    public DepartmentDto(long id, String name, List<MemberDto> members){
        this(id,name);
        this.members =members;
    }

    public DepartmentDto(Department department){
        this.id = department.getId();
        this.name = department.getName();
        this.members = department.getMemberList().stream().map(member -> new MemberConverter().toDto(member)).toList();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberDto> getMembers() {
        return members;
    }

    public void setMembers(List<MemberDto> members) {
        this.members = members;
    }
}
