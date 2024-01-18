package fon.stefan.januarski_rok.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned",updatable = false,insertable = false)
    private Long id;
    @NotEmpty(message = "Ime je obavezno polje")
    @Size(min = 2, max = 10, message = "Broj znakova je od 2 do 10")
    @Column(name = "name",unique = true)
    private String name;

    @NotEmpty(message = "Kratak zapis imena je obavezno polje.")
    @Column(name = "short_name",unique = true)
    private String shortName;
    @JsonManagedReference
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, targetEntity = Member.class, fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Member> memberList;

    @JsonManagedReference
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL,targetEntity = Subject.class,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Subject> subjects;

    public  Department(long id){
        this.id=id;
    }

    public Department(long id, String name, String shortName) {
        this.id=id;
        this.name=name;
        this.shortName=shortName;
    }
}
