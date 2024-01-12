package fon.stefan.januarski_rok.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AcademicTitleHistoryDto {
    @JsonProperty(value = "member", required = true)
    private MemberDto memberDto;
    @JsonProperty(value = "department", required = true)
    private DepartmentDto departmentDto;
    @JsonProperty(value = "ascademic_title",required = true)
    private AcademicTitleDto academicTitleDto;
    @JsonProperty(value = "scientific_field")
    private ScientificFieldDto scientificFieldDto;
    @JsonProperty(value = "start_date")
    private String startDate;
    @JsonProperty(value = "end_date")
    private String endDate;

    public AcademicTitleHistoryDto() {
    }

    public AcademicTitleHistoryDto(MemberDto memberDto, DepartmentDto departmentDto, AcademicTitleDto academicTitleDto, ScientificFieldDto scientificFieldDto, String startDate, String endDate) {
        this.memberDto = memberDto;
        this.departmentDto = departmentDto;
        this.academicTitleDto = academicTitleDto;
        this.scientificFieldDto = scientificFieldDto;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public MemberDto getMemberDto() {
        return memberDto;
    }

    public void setMemberDto(MemberDto memberDto) {
        this.memberDto = memberDto;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }

    public AcademicTitleDto getAcademicTitleDto() {
        return academicTitleDto;
    }

    public void setAcademicTitleDto(AcademicTitleDto academicTitleDto) {
        this.academicTitleDto = academicTitleDto;
    }

    public ScientificFieldDto getScientificFieldDto() {
        return scientificFieldDto;
    }

    public void setScientificFieldDto(ScientificFieldDto scientificFieldDto) {
        this.scientificFieldDto = scientificFieldDto;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public static Date toDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(date);
    }
    public static String toString(Date date){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
}
