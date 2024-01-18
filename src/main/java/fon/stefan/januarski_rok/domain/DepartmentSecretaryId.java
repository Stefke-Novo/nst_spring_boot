package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentSecretaryId implements Serializable {

    @Id
    @Column(columnDefinition = "bigint unsigned")
    private long id;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "id",columnDefinition = "bigint unsigned")
    private Member member;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",referencedColumnName = "id",columnDefinition = "bigint unsigned")
    private Department department;

}
