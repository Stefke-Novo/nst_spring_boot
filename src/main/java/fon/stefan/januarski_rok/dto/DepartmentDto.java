package fon.stefan.januarski_rok.dto;

import fon.stefan.januarski_rok.domain.Member;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.swing.text.html.Option;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class DepartmentDto implements Serializable {
    private long id;

    @NotNull
    @Size(min = 2,max = 10, message = "Broj znakova [2-10]")
    private String name;

    private List<Member> members;
    public DepartmentDto(){
    }

    public DepartmentDto(long id, String name){
        this.id=id;
        this.name=name;
    }
    public DepartmentDto(long id, String name, List<Member> members){
        this(id,name);
        this.members =members;
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

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
