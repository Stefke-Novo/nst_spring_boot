package fon.stefan.januarski_rok.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HeadOfDepartmentDto {
    @JsonProperty(value = "department", required = true)
    private DepartmentDto department;
    @JsonProperty(value = "member_id", required = true)
    private long memberId;
    @JsonProperty(value = "head_of_department_id", required = true)
    private long id;
    @JsonProperty(value = "first_name")
    private String firstName;
    @JsonProperty(value = "last_name")
    private String lastName;
    @JsonProperty(value = "education_title")
    private String educationTitle;

    public HeadOfDepartmentDto(DepartmentDto department, long memberId, long id, String firstName, String lastName, String educationTitle) {
        this.department = department;
        this.memberId = memberId;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationTitle = educationTitle;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
