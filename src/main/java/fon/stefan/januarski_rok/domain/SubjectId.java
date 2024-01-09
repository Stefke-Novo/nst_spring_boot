package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class SubjectId implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn(name = "department_id", referencedColumnName = "id",columnDefinition = "bigint unsigned")
    private Department department;

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
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public SubjectId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectId subjectId = (SubjectId) o;
        return id == subjectId.id && Objects.equals(department, subjectId.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department);
    }
}
