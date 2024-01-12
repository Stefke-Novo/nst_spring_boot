package fon.stefan.januarski_rok.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity(name = "DepartmentSecretary")
@Table(name = "department_secretary")
@IdClass(DepartmentSecretaryId.class)
public class DepartmentSecretary {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long id;


    @JsonBackReference
    @Id
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "department_id",referencedColumnName = "department_id",columnDefinition = "bigint unsigned"),
            @JoinColumn(name = "member_id", referencedColumnName = "id",columnDefinition = "bigint unsigned")
    })
    private Member member;

    public DepartmentSecretary() {
    }

    public DepartmentSecretary(long id, long id1, long memberId) {
        this.id=id;
        this.member = new Member(memberId,id1);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
