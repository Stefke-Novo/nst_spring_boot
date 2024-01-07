package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "scientific_field")
public class ScientificField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public ScientificField() {
    }
    @OneToMany(mappedBy = "scientificField")
    private List<Member> memberList;
    public ScientificField(long id, String name) {
        this.id = id;
        this.name = name;
        this.memberList =new ArrayList<>();
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

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }
}
