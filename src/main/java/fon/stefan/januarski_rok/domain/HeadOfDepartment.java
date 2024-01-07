package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "head_of_department_history")
public class HeadOfDepartment {

    @Id
    private long id;
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "department_id", referencedColumnName = "department_id"),
            @JoinColumn(name = "member_id", referencedColumnName = "id")
    })
    private Member member;

    public HeadOfDepartment(long id) {
        this.id = id;
    }

    public HeadOfDepartment() {
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
