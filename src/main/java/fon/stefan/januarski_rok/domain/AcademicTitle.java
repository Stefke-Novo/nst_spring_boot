package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "academic_title")
public class AcademicTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "academicTitle",cascade = CascadeType.ALL,targetEntity = AcademicTitleHistory.class)
    private List<AcademicTitleHistory> memberList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AcademicTitleHistory> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<AcademicTitleHistory> memberList) {
        this.memberList = memberList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
