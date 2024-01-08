package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "academic_title_history",uniqueConstraints =
        {@UniqueConstraint(columnNames = {"department_id","member_id"}),
        @UniqueConstraint(columnNames = {"academic_title_id"}),
        @UniqueConstraint(columnNames = {"scientific_field_id"})})
@IdClass(AcademicTitleHistory.class)
public class AcademicTitleHistory extends AcademicTitleHistoryId {


    @Id
    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "department_id", referencedColumnName = "department_id",columnDefinition = "bigint unsigned not null"),
            @JoinColumn(name = "member_id", referencedColumnName = "id",columnDefinition = "bigint unsigned not null")
    })
    private Member member;
    @Column(name = "department_id",columnDefinition = "bigint unsigned not null")
    private long departmentId;

    @Column(name = "member_id",columnDefinition = "bigint unsigned not null")
    private long memberId;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "academic_title_id",columnDefinition = "bigint UNSIGNED NOT NULL",referencedColumnName = "id")
    private AcademicTitle academicTitle;

    @Column(name = "academic_title_id",columnDefinition = "bigint UNSIGNED NOT NULL")
    private long academicTitleId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "scientific_field_id",columnDefinition = "bigint UNSIGNED NOT NULL", referencedColumnName = "id")
    private ScientificField scientificField;

    @Column(name = "scientific_field_id")
    private long scientificFieldId;

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

//    public long getAcademicTitleHistroyId() {
//        return academicTitleHistroyId;
//    }
//
//    public void setAcademicTitleHistroyId(long academicTitleHistroyId) {
//        this.academicTitleHistroyId = academicTitleHistroyId;
//    }

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
