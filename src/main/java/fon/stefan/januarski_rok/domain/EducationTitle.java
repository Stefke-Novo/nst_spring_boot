package fon.stefan.januarski_rok.domain;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "education_title")
public class EducationTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long id;

    private String title;

    @OneToMany(mappedBy = "educationTitle",cascade = CascadeType.ALL,targetEntity = Member.class)
    List<Member> members;

    public EducationTitle(){

    }
    public EducationTitle(String title){
        this.title = title;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return title;
    }
}
