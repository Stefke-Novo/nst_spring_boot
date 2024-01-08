package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "department_secretary",uniqueConstraints = @UniqueConstraint(columnNames = {"department_id","member_id"}))
@IdClass(DepartmentSecretaryId.class)
public class DepartmentSecretary {

    @Id
    @Column(columnDefinition = "bigint unsigned not null auto_increment", name = "id")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "department_id", referencedColumnName = "department_id",columnDefinition = "bigint unsigned not null"),
            @JoinColumn(name = "member_id", referencedColumnName = "id",columnDefinition = "bigint unsigned not null")
    })
    private Member member;

    @Column(name = "department_id",columnDefinition = "bigint unsigned not null")
    private long departmentId;

    @Column(name = "member_id",columnDefinition = "bigint unsigned not null")
    private long memberId;

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
