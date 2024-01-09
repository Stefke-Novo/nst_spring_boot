package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class HeadOfDepartmentId implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long id;


    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "department_id",referencedColumnName = "department_id", columnDefinition = "bigint unsigned"),
            @JoinColumn(name = "member_id",referencedColumnName = "id", columnDefinition = "bigint unsigned")
    })
    private Member member;

    public HeadOfDepartmentId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadOfDepartmentId that = (HeadOfDepartmentId) o;
        return id == that.id && Objects.equals(member, that.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, member);
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
