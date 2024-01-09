package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="member")
public class Member{

    @Id
    @Column(name="id",columnDefinition = "bigint unsigned")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @Column(name="department_id",columnDefinition = "bigint unsigned")
    private long departmentId;
    @ManyToOne(targetEntity = Department.class,optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id",referencedColumnName = "id",columnDefinition = "bigint unsigned")
    private Department department;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(optional = false)
    @MapsId("educationTitleId")
    @JoinColumn(name = "education_title_id",referencedColumnName = "id",
            columnDefinition = "bigint unsigned")
    private EducationTitle educationTitle;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL,targetEntity = DepartmentSecretary.class)
    private List<DepartmentSecretary> deparmentSecretaryHistory;

    @OneToMany(mappedBy ="member",cascade = CascadeType.ALL,targetEntity = HeadOfDepartment.class)
    private List<HeadOfDepartment> headOfDepartmentHistory;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL,targetEntity = AcademicTitleHistory.class)
    private List<AcademicTitleHistory> academicTitles;

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

    public List<DepartmentSecretary> getDeparmentSecretaryHistory() {
        return deparmentSecretaryHistory;
    }

    public void setDeparmentSecretaryHistory(List<DepartmentSecretary> deparmentSecretaryHistory) {
        this.deparmentSecretaryHistory = deparmentSecretaryHistory;
    }

    public List<HeadOfDepartment> getHeadOfDepartmentHistory() {
        return headOfDepartmentHistory;
    }

    public void setHeadOfDepartmentHistory(List<HeadOfDepartment> headOfDepartmentHistory) {
        this.headOfDepartmentHistory = headOfDepartmentHistory;
    }

    public List<AcademicTitleHistory> getAcademicTitles() {
        return academicTitles;
    }

    public void setAcademicTitles(List<AcademicTitleHistory> academicTitles) {
        this.academicTitles = academicTitles;
    }

    public Member(long memberId, String firstName, String lastName) {
        this.id=memberId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
