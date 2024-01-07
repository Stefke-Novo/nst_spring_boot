package fon.stefan.januarski_rok.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class DepartmentDto implements Serializable {
    private long id;

    @NotNull
    @Size(min = 2,max = 10, message = "Broj znakova [2-10]")
    private String name;

    public DepartmentDto(){}

    public DepartmentDto(long id, String name){

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
}
