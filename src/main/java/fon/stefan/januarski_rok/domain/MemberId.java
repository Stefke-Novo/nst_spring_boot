package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;


public class MemberId implements Serializable{

    @Column(name = "id",columnDefinition = "bigint unsigned")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="department_id",columnDefinition = "bigint unsigned")
    private long departmentId;

    public MemberId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberId memberId = (MemberId) o;
        return departmentId == memberId.departmentId && Objects.equals(id, memberId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId);
    }
}
