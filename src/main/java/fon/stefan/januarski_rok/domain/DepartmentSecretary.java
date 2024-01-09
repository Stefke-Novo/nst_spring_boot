package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

@Entity(name = "DepartmentSecretary")
@Table(name = "department_secretary")
@IdClass(DepartmentSecretaryId.class)
public class DepartmentSecretary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long id;


    @Id
    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "department_id",referencedColumnName = "department_Id",columnDefinition = "bigint unsigned"),
            @JoinColumn(name = "member_id", referencedColumnName = "id",columnDefinition = "bigint unsigned")
    })
    private Member member;

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
