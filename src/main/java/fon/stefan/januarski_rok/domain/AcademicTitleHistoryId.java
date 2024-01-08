package fon.stefan.januarski_rok.domain;

import jakarta.persistence.Column;

import java.io.Serializable;

public class AcademicTitleHistoryId implements Serializable {



    private long departmentId;


    private long memberId;


    private long scientificFieldId;


    private long academicTitleId;

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public long getScientificFieldId() {
        return scientificFieldId;
    }

    public void setScientificFieldId(long scientificFieldId) {
        this.scientificFieldId = scientificFieldId;
    }

    public long getAcademicTitleId() {
        return academicTitleId;
    }

    public void setAcademicTitleId(long academicTitleId) {
        this.academicTitleId = academicTitleId;
    }
}
