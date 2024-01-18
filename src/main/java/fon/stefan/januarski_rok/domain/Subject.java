package fon.stefan.januarski_rok.domain;

import fon.stefan.januarski_rok.converter.impl.DepartmentConverter;
import fon.stefan.januarski_rok.dto.SubjectDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subject",uniqueConstraints = @UniqueConstraint(columnNames = {"department_id"}))
//@IdClass(SubjectId.class)
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "bigint unsigned")
    private long id;

    @NotEmpty(message = "Ime je obavezno polje")
    @Size(min = 2, max = 10, message = "Broj znakova je od 2 do 10")
    @Column(name = "name")
    private String name;
    @Column(name = "espb")
    private int espb;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id",columnDefinition = "bigint unsigned")
    private Department department;

    public Subject(SubjectDto dto) {
        this.id=dto.getId();
        this.name=dto.getName();
        this.espb=dto.getEspb();
        this.department=new DepartmentConverter().toEntity(dto.getDepartmentDto());
    }

}
