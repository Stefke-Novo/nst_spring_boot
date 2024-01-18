package fon.stefan.januarski_rok.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import fon.stefan.januarski_rok.dto.AcademicTitleDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "academic_title")
public class AcademicTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long id;


    @NotEmpty(message = "Title must not be empty.")
    @Column(name = "title")
    private String title;

    @JsonManagedReference
    @Size.List({
            @Size(min = 1, message = "AcademicTitle entity must contain list with at least one AcademicTitleHistory entity.")
    })
    @OneToMany(mappedBy = "academicTitle",cascade = CascadeType.ALL,targetEntity = AcademicTitleHistory.class,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<AcademicTitleHistory> memberList;

    public AcademicTitle(int i, String academicTitle) {
        this.id=i;
        this.title=academicTitle;
    }

    public AcademicTitle(AcademicTitleDto academicTitleDto) {
        this.id=academicTitleDto.getId();
        this.title= academicTitleDto.getTitle();
    }


    @Override
    public String toString() {
        return title;
    }
}
