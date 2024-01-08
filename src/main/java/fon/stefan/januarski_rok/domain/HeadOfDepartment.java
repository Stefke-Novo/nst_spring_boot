package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "head_of_department",uniqueConstraints = {@UniqueConstraint(columnNames = { "department_id", "member_id" }) })
@IdClass(HeadOfDepartmentId.class)
public class HeadOfDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id"
            ,columnDefinition = "bigint unsigned not null auto_increment")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "department_id",referencedColumnName = "department_id",
                    columnDefinition = "bigint unsigned not null"),
            @JoinColumn(name = "member_id",referencedColumnName = "id",
                    columnDefinition = "bigint unsigned not null"),
    })
    private Member member;

    @Id
    @Column(name = "department_id",columnDefinition = "bigint unsigned not null")
    private long departmentId;
    @Id
    @Column(name = "member_id")
    private long memberId;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
