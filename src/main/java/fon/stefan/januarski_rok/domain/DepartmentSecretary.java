package fon.stefan.januarski_rok.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department_secretary")
@IdClass(DepartmentSecretaryId.class)
public class DepartmentSecretary {

    @Id
    @Column(columnDefinition = "bigint unsigned")
    private long id;

    @Id
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "id",columnDefinition = "bigint unsigned")
    private Member member;

    @Id
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",referencedColumnName = "id",columnDefinition = "bigint unsigned")
    private Department department;


}
