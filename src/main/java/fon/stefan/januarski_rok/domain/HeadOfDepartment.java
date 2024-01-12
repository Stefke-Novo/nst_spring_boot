package fon.stefan.januarski_rok.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "head_of_department")
@IdClass(HeadOfDepartmentId.class)
public class HeadOfDepartment {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long id;

    @JsonBackReference
    @Id
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "department_id",referencedColumnName = "department_id",columnDefinition = "bigint unsigned"),
            @JoinColumn(name = "member_id",referencedColumnName = "id",columnDefinition = "bigint unsigned")
    })
    private Member member;



    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
