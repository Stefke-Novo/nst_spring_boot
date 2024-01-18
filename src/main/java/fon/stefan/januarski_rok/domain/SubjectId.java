package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class SubjectId implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "bigint unsigned",nullable = false)
    private long id;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id",columnDefinition = "bigint unsigned")
    private Department pdepartment;

    public SubjectId(long id){
        this.id=id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return pdepartment;
    }

    public void setDepartment(Department pdepartment) {
        this.pdepartment = pdepartment;
    }

    public SubjectId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectId subjectId = (SubjectId) o;
        return id == subjectId.id && Objects.equals(pdepartment, subjectId.pdepartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pdepartment);
    }
}
