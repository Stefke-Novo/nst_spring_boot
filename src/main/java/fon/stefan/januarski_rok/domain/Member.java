package fon.stefan.januarski_rok.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="member")
//@IdClass(MemberId.class)
public class Member{

    @Column(name = "id",columnDefinition = "bigint unsigned")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    //@Id
    @ManyToOne(targetEntity = Department.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",referencedColumnName = "id",columnDefinition = "bigint unsigned")
    private Department department;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "Entity Member must have EducationTitle entity.")
    @JsonBackReference
    @ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "education_title_id",referencedColumnName = "id",
            columnDefinition = "bigint unsigned",nullable = false)
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
        this.department = new Department(departmentId);
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.academicTitles=new ArrayList<>(List.of(new AcademicTitleHistory(this, academicTitle, scientificField))) ;
        this.educationTitle = new EducationTitle(educationTitle);
    }

    public Member(long memberId) {
        this.id=memberId;
    }
}
