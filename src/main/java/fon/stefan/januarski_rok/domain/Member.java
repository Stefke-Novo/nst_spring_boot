package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="member")
public class Member {

    @Id
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "educaiton_title_id")
    private EducationTitle educationTitle;

    @OneToMany(mappedBy = "member")
    private List<DepartmentSecretary> deparmentSecretaryHistory;

    @OneToMany(mappedBy = "member")
    private List<HeadOfDepartment> headOfDepartmentHistory;

    public Member(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
}
