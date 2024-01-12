package fon.stefan.januarski_rok.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class DepartmentSecretaryDto implements Serializable {
    @JsonProperty(value = "department",required = true)
    private DepartmentDto departmentDto;
    @JsonProperty(value = "member_id",required = true)
    private long memberId;
    @JsonProperty(value = "id",required = true)
    private long id;
    @JsonProperty(value = "first_name")
    private String firstName;
    @JsonProperty(value = "last_name")
    private String lastName;
    @JsonProperty(value = "education_title")
    private String educationTitle;

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEducationTitle() {
        return educationTitle;
    }

    public void setEducationTitle(String educationTitle) {
        this.educationTitle = educationTitle;
    }

    public DepartmentSecretaryDto(DepartmentDto departmentDto, long memberId, String firstName, String lastName, String educationTitle) {
        this.departmentDto = departmentDto;
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationTitle = educationTitle;
    }
}
