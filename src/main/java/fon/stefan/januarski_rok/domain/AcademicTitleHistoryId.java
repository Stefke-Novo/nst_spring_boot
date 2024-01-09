package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

import java.io.Serializable;

public class AcademicTitleHistoryId implements Serializable {


    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "department_id", referencedColumnName = "department_id",columnDefinition = "bigint unsigned"),
            @JoinColumn(name = "member_id", referencedColumnName = "id",columnDefinition = "bigint unsigned")
    })
    private Member member;


    @ManyToOne
    @JoinColumn(name = "academic_title_id",referencedColumnName = "id",columnDefinition = "undefined")
    private AcademicTitle academicTitle;
}
