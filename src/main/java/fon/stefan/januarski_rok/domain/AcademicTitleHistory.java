package fon.stefan.januarski_rok.domain;


import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "academic_title_history")
@IdClass(AcademicTitleHistory.class)
public class AcademicTitleHistory extends AcademicTitleHistoryId {


    @Id
    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "department_id", referencedColumnName = "department_id",columnDefinition = "bigint unsigned"),
            @JoinColumn(name = "member_id", referencedColumnName = "id",columnDefinition = "bigint unsigned")
    })
    private Member member;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "academic_title_id",columnDefinition = "bigint unsigned",referencedColumnName = "id")
    private AcademicTitle academicTitle;

    @ManyToOne(optional = false)
    @JoinColumn(name = "scientific_field_id",columnDefinition = "bigint unsigned", referencedColumnName = "id")
    private ScientificField scientificField;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = true)
    private Date endDate;


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


    public ScientificField getScientificField() {
        return scientificField;
    }

    public void setScientificField(ScientificField scientificField) {
        this.scientificField = scientificField;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
