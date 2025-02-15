package fon.stefan.januarski_rok.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import fon.stefan.januarski_rok.converter.impl.AcademicTitleConverter;
import fon.stefan.januarski_rok.converter.impl.MemberConverter;
import fon.stefan.januarski_rok.converter.impl.ScientificFieldConverter;
import fon.stefan.januarski_rok.dto.AcademicTitleHistoryDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.text.ParseException;
import java.util.Date;
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "academic_title_history")
@IdClass(AcademicTitleHistoryId.class)
public class AcademicTitleHistory{

    @JsonBackReference
    @NotEmpty(message = "Entity must have Entity Member.")
    @Id
    @ManyToOne(optional = false,cascade = CascadeType.ALL,targetEntity = Member.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "id",columnDefinition = "bigint unsigned",nullable = false)
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
    @Column(name = "end_date")
    private Date endDate;


    public AcademicTitleHistory(Member member, String academicTitle, String scientificField) {
        this.member=member;
        this.academicTitle=new AcademicTitle(0,academicTitle);
        this.scientificField=new ScientificField(0,scientificField);
    }

    public AcademicTitleHistory(AcademicTitleHistoryDto academicTitleHistoryDto) {
        this.member = new MemberConverter().toEntity(academicTitleHistoryDto.getMemberDto());
        this.scientificField=new ScientificFieldConverter().toEntity(academicTitleHistoryDto.getScientificFieldDto());
        this.academicTitle = new AcademicTitleConverter().toEntity(academicTitleHistoryDto.getAcademicTitleDto());
        try {
            this.startDate = AcademicTitleHistoryDto.toDate(academicTitleHistoryDto.getStartDate());
            this.endDate = AcademicTitleHistoryDto.toDate(academicTitleHistoryDto.getEndDate());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
