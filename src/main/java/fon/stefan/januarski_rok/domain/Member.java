package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="member",uniqueConstraints = @UniqueConstraint(columnNames = {"department_id"}))
@IdClass(MemberId.class)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",
            columnDefinition = "bigint unsigned not null auto_increment")
    private long id;
    @Id
    private long department_id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id",
            referencedColumnName = "id",
            columnDefinition = "bigint unsigned not null")
    private Department department;


    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "education_title_id",
            columnDefinition = "bigint unsigned not null",
            referencedColumnName = "id")
    private EducationTitle educationTitle;

    @OneToMany(mappedBy = "member")
    private List<DepartmentSecretary> deparmentSecretaryHistory;

    @OneToMany(mappedBy = "member")
    private List<HeadOfDepartment> headOfDepartmentHistory;

    @OneToMany(mappedBy = "member")
    private List<AcademicTitleHistory> academicTitles;



    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(long department_id) {
        this.department_id = department_id;
    }
}
