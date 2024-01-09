package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned",updatable = false,insertable = false)
    private Long id;
    @NotEmpty(message = "Ime je obaezno polje")
    @Size(min = 2, max = 10, message = "Broj znakova je od 2 do 10")
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "department", targetEntity = Member.class)
    private Set<Member> memberList = new HashSet<>();

    @OneToMany(mappedBy = "department",targetEntity = Subject.class)
    private Set<Subject> subjects = new HashSet<>();

    public Department(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
