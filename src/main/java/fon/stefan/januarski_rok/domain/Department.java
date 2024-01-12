package fon.stefan.januarski_rok.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "department")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned",updatable = false,insertable = false)
    private Long id;
    @NotEmpty(message = "Ime je obaezno polje")
    @Size(min = 2, max = 10, message = "Broj znakova je od 2 do 10")
    @Column(name = "name")
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "pdepartment", cascade = CascadeType.ALL, targetEntity = Member.class, fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Member> memberList;

    @JsonManagedReference
    @OneToMany(mappedBy = "pdepartment",cascade = CascadeType.ALL,targetEntity = Subject.class,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Subject> subjects;

    public  Department(long id){
        this.id=id;
    }

    public Department(long id, String name) {
        this(id);
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

    public void setId(Long id) {
        this.id = id;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
        this.memberList.forEach(member->member.setDepartment(this));
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
        this.subjects.forEach(subject->subject.setPdepartment(this));
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\''+
                '}';
    }
}
