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
@Table(name = "head_of_department")
@IdClass(HeadOfDepartmentId.class)
public class HeadOfDepartment {

    @Id
    @Column(columnDefinition = "bigint unsigned")
    private long id;

    @Id
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",referencedColumnName = "id", columnDefinition = "bigint unsigned")
    private Member member;

    @Id
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",referencedColumnName = "id", columnDefinition = "bigint unsigned")
    private Department department;


}
