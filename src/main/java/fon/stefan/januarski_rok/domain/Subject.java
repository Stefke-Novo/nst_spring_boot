package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "subject",uniqueConstraints = @UniqueConstraint(columnNames = {"department_id"}))
@IdClass(SubjectId.class)
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private Long id;

    @NotEmpty(message = "Ime je obavezno polje")
    @Size(min = 2, max = 10, message = "Broj znakova je od 2 do 10")
    @Column(name = "name")
    private String name;
    @Column(name = "espb")
    private int esbp;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id", referencedColumnName = "id",columnDefinition = "bigint unsigned")
    private Department department;

    public Subject() {
    }

    public Subject(Long id, String name, int esbp, Department department) {
        this.id = id;
        this.name = name;
        this.esbp = esbp;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEsbp() {
        return esbp;
    }

    public void setEsbp(int esbp) {
        this.esbp = esbp;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

//    public long getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(long departmentId) {
//        this.departmentId = departmentId;
//    }
}
