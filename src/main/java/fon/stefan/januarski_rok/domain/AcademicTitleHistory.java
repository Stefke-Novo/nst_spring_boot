package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "academic_title_history")
public class AcademicTitleHistory {
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "department_id", referencedColumnName = "department_id"),
            @JoinColumn(name = "member_id", referencedColumnName = "id")
    })
    private Member member;
    @Id
    @ManyToOne
    @JoinColumn(name = "academic_title_id")
    private AcademicTitle academicTitle;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long academicTitleHistroyId;

    @Id
    @ManyToOne
    @JoinColumn(name = "scientific_field_id")
    private ScientificField scientificField;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = true)
    private Date endDate;




}
