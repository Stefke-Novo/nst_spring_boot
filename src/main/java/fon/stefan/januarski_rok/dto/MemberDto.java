package fon.stefan.januarski_rok.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fon.stefan.januarski_rok.domain.*;

import java.io.Serializable;

public class MemberDto implements Serializable {
    @JsonProperty(value = "department_id",required = true)
    private long departmentId;
    @JsonProperty(value = "id",required = true)
    private long id;
    @JsonProperty(value = "first_name",required = true)
    private String firstName;
    @JsonProperty(value = "last_name", required = true)
    private String lastName;
    private String academicTitle;

    @JsonProperty(value = "education_title", required = true)
    private String educationTitle;

    private String scientificField;

    public MemberDto() {
    }

    public MemberDto(String firstName, String lastName, String academicTitle, String educationTitle, String scientificField) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.academicTitle = academicTitle;
        this.educationTitle = educationTitle;
        this.scientificField = scientificField;
    }
    public MemberDto(Member member){
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.academicTitle = getAcademicTitle(member);
        this.educationTitle = member.getEducationTitle().toString();
        this.scientificField = getScientificField(member);
    }

    public MemberDto(long id, long id1, String firstName, String lastName, EducationTitle educationTitle, AcademicTitleHistory first, AcademicTitle academicTitle, ScientificField scientificField) {
        this.departmentId=id;
        this.id=id1;
        this.firstName=firstName;
        this.lastName=lastName;
        this.educationTitle=educationTitle.getTitle();
        this.academicTitle=academicTitle.getTitle();
        this.scientificField=scientificField.getName();
    }

    public MemberDto(long id, long id1, String firstName, String lastName, EducationTitle educationTitle) {
        this.id=id1;
        this.departmentId =id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.educationTitle=educationTitle.getTitle();
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

    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }

    public String getEducationTitle() {
        return educationTitle;
    }

    public void setEducationTitle(String educationTitle) {
        this.educationTitle = educationTitle;
    }

    public String getScientificField() {
        return scientificField;
    }

    public void setScientificField(String scientificField) {
        this.scientificField = scientificField;
    }

    private boolean academicTitleNotExist(Member member){
        return member.getAcademicTitles().isEmpty();
    }
    private String getAcademicTitle(Member member){
        if(academicTitleNotExist(member))
            return "";
        return member.getAcademicTitles().getLast().getAcademicTitle().toString();
    }

    private String getScientificField(Member member){
        if(academicTitleNotExist(member))
            return  "";
        return member.getAcademicTitles().getLast().getScientificField().toString();
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
