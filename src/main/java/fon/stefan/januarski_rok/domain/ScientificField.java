package fon.stefan.januarski_rok.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "scientific_field")
public class ScientificField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long id;
    private String name;

    public ScientificField(String name){
        this.name = name;
    }


    @JsonBackReference
    @OneToMany(mappedBy = "scientificField",cascade = CascadeType.ALL,targetEntity = AcademicTitleHistory.class,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<AcademicTitleHistory> memberList;

    public ScientificField(int i, String scientificField) {
        this.id=i;
        this.name=scientificField;
    }

    @Override
    public String toString() {
        return name;
    }
}
