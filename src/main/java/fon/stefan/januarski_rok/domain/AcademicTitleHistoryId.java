package fon.stefan.januarski_rok.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicTitleHistoryId implements Serializable {


    @ManyToOne(optional = false, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", referencedColumnName = "id",columnDefinition = "bigint unsigned")
    private Member member;

    @ManyToOne(optional = false,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "academic_title_id",referencedColumnName = "id",columnDefinition = "bigint unsigned")
    private AcademicTitle academicTitle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademicTitleHistoryId that = (AcademicTitleHistoryId) o;
        return Objects.equals(member, that.member) && Objects.equals(academicTitle, that.academicTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, academicTitle);
    }

}
