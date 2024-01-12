package fon.stefan.januarski_rok.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="member")
@IdClass(MemberId.class)
public class Member{

    @Column(name = "id",columnDefinition = "bigint unsigned")
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @Id
    @ManyToOne(targetEntity = Department.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",referencedColumnName = "id",columnDefinition = "bigint unsigned")
    private Department pdepartment;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @JsonBackReference
    @ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "education_title_id",referencedColumnName = "id",
            columnDefinition = "bigint unsigned")
    @NotEmpty(message = "Entity Member must have EducationTitle entity.")
    private EducationTitle educationTitle;

    @JsonManagedReference
    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL,targetEntity = DepartmentSecretary.class,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<DepartmentSecretary> departmentSecretaryHistory;

    @JsonManagedReference
    @OneToMany(mappedBy ="member",cascade = CascadeType.ALL,targetEntity = HeadOfDepartment.class, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<HeadOfDepartment> headOfDepartmentHistory;

    @JsonManagedReference
    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    @Size.List({
            @Size(min = 1, message = "Entity Member must have at least 1 AcademicTitleHIstoryEntity,")
    })
    private List<AcademicTitleHistory> academicTitles;


    public Member(long departmentId, long id, String firstName, String lastName, String academicTitle, String educationTitle, String scientificField){
        this.pdepartment = new Department(departmentId);
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.academicTitles=new ArrayList<>(List.of(new AcademicTitleHistory(this, academicTitle, scientificField))) ;
        this.educationTitle = new EducationTitle(educationTitle);
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

    public EducationTitle getEducationTitle() {
        return educationTitle;
    }

    public void setEducationTitle(EducationTitle educationTitle) {
        this.educationTitle = educationTitle;
    }

    public List<DepartmentSecretary> getDepartmentSecretaryHistory() {
        return departmentSecretaryHistory;
    }

    public void setDepartmentSecretaryHistory(List<DepartmentSecretary> departmentSecretaryHistory) {
        this.departmentSecretaryHistory = departmentSecretaryHistory;
        this.departmentSecretaryHistory.forEach(departmentSecretary -> departmentSecretary.setMember(this));
    }

    public List<HeadOfDepartment> getHeadOfDepartmentHistory() {
        return headOfDepartmentHistory;
    }

    public void setHeadOfDepartmentHistory(List<HeadOfDepartment> headOfDepartmentHistory) {
        this.headOfDepartmentHistory = headOfDepartmentHistory;
        this.headOfDepartmentHistory.forEach(headOfDepartment -> headOfDepartment.setMember(this));
    }

    public List<AcademicTitleHistory> getAcademicTitles() {
        return academicTitles;
    }

    public void setAcademicTitles(List<AcademicTitleHistory> academicTitles) {
        this.academicTitles = academicTitles;
        this.academicTitles.forEach(academicTitle->academicTitle.setMember(this));
    }

    public Member(long memberId, String firstName, String lastName) {
        this.id=memberId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Member(long departmentId, long memberId, String firstName, String lastName){
        this(memberId,firstName,lastName);
        this.pdepartment = new Department();
        this.pdepartment.setId(departmentId);
    }
    public Department getDepartment() {
        return pdepartment;
    }

    public void setDepartment(Department pdepartment) {
        this.pdepartment = pdepartment;
    }

    public Member() {
    }
    public Member(long departmentId, long id){
        this.pdepartment = new Department(departmentId,"");
        this.id = id;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", departmentId=" + this.getDepartment().getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
