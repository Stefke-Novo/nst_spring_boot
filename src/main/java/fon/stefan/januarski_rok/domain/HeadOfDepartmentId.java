package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

import java.io.Serializable;

public class HeadOfDepartmentId implements Serializable {
    private long departmentId;
    private long memberId;

    private long id;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
