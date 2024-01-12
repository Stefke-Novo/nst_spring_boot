package fon.stefan.januarski_rok.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class AcademicTitleHistoryId implements Serializable {


    @ManyToOne(optional = false, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "department_id", referencedColumnName = "department_id",columnDefinition = "bigint unsigned"),
            @JoinColumn(name = "member_id", referencedColumnName = "id",columnDefinition = "bigint unsigned")
    })
    private Member member;

    @ManyToOne(optional = false,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "academic_title_id",referencedColumnName = "id",columnDefinition = "bigint unsigned")
    private AcademicTitle academicTitle;

    public AcademicTitleHistoryId() {
    }

    public AcademicTitleHistoryId(Member member, AcademicTitle academicTitle){
        this.member = member;
        this.academicTitle = academicTitle;
    }

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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public AcademicTitle getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(AcademicTitle academicTitle) {
        this.academicTitle = academicTitle;
    }
}
