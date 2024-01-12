package fon.stefan.januarski_rok.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.Cascade;

import java.util.Date;
@Entity
@Table(name = "academic_title_history")
@IdClass(AcademicTitleHistoryId.class)
public class AcademicTitleHistory{

    @Id
    @ManyToOne(optional = false,cascade = CascadeType.ALL,targetEntity = Member.class,fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumns({
            @JoinColumn(name = "department_id", referencedColumnName = "department_id",columnDefinition = "bigint unsigned",nullable = false),
            @JoinColumn(name = "member_id", referencedColumnName = "id",columnDefinition = "bigint unsigned",nullable = false)
    })
    @NotEmpty(message = "Entity must have Entity Member.")
    private Member member;

    @Id
    @ManyToOne(optional = false, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "academic_title_id",columnDefinition = "bigint unsigned",referencedColumnName = "id", nullable = false)
    private AcademicTitle academicTitle;


    @ManyToOne(optional = false, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "scientific_field_id",columnDefinition = "bigint unsigned", referencedColumnName = "id", nullable = false)
    private ScientificField scientificField;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date",nullable = false)
    private Date startDate;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = true)
    private Date endDate;

    public AcademicTitleHistory(){

    }

    public AcademicTitleHistory(Member member, AcademicTitle academicTitle, ScientificField scientificField, Date startDate, Date endDate) {
        this.member = member;
        this.academicTitle = academicTitle;
        this.scientificField = scientificField;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public AcademicTitleHistory(long departmentId, long memberId, String academicTitle, String scientificField){
        this.member = new Member(departmentId,memberId);
        this.academicTitle =new AcademicTitle(academicTitle, this);
        this.scientificField = new ScientificField(scientificField);
    }
    public AcademicTitleHistory(Member member,String academicTitle, String scientificField){
        this.member = member;
        this.academicTitle =new AcademicTitle(academicTitle, this);
        this.scientificField = new ScientificField(scientificField);
        this.setStartDate(new Date());
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
