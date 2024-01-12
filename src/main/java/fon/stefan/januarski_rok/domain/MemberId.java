package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


public class MemberId implements Serializable{

    @Column(name = "id",columnDefinition = "bigint unsigned")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(name="department_id",columnDefinition = "bigint unsigned")
//    private long departmentId;
//
//    public MemberId() {
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MemberId memberId = (MemberId) o;
//        return departmentId == memberId.departmentId && Objects.equals(id, memberId.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, departmentId);
//    }


    public MemberId(long id, Department pdepartment) {
        this.id = id;
        this.pdepartment = pdepartment;
    }

    @ManyToOne(targetEntity = Department.class,optional = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",referencedColumnName = "id",columnDefinition = "bigint unsigned")
    private Department pdepartment;

    public MemberId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberId memberId = (MemberId) o;
        return Objects.equals(id, memberId.id) && Objects.equals(pdepartment, memberId.pdepartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pdepartment);
    }
}
