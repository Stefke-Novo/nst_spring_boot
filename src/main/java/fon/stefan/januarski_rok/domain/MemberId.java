package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


public class MemberId implements Serializable{

    @Column(name = "id",columnDefinition = "bigint unsigned")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Id
    @Column(name="department_id",columnDefinition = "bigint unsigned")
    private long departmentId;
//    @ManyToOne(targetEntity = Department.class,optional = false,cascade = CascadeType.ALL)
//    @JoinColumn(name = "department_id",referencedColumnName = "id",columnDefinition = "bigint unsigned")
//    private Department department;

//    public MemberId() {
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MemberId memberId = (MemberId) o;
//        return Objects.equals(id, memberId.id) && Objects.equals(department, memberId.department);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, department);
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }

    public MemberId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberId memberId = (MemberId) o;
        return departmentId == memberId.departmentId && Objects.equals(id, memberId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId);
    }
}
