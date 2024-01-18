package fon.stefan.januarski_rok.domain;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeadOfDepartmentId implements Serializable {



    @Column(columnDefinition = "bigint unsigned")
    private long id;


    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",referencedColumnName = "id", columnDefinition = "bigint unsigned")
    private Member member;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",referencedColumnName = "id", columnDefinition = "bigint unsigned")
    private Department department;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadOfDepartmentId that = (HeadOfDepartmentId) o;
        return id == that.id && Objects.equals(member, that.member) && Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, member, department);
    }
}
