package fon.stefan.januarski_rok.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

@Entity
@Table(name = "academic_title")
public class AcademicTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private long id;
    @NotEmpty(message = "Title must not be empty.")
    @Column(name = "title")
    private String title;

    @JsonManagedReference
    @Size.List({
            @Size(min = 1, message = "AcademicTitle entity must contain list with at least one AcademicTitleHistory entity.")
    })
    @OneToMany(mappedBy = "academicTitle",cascade = CascadeType.ALL,targetEntity = AcademicTitleHistory.class,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<AcademicTitleHistory> memberList;

    public AcademicTitle(){

    }
    public AcademicTitle(String title, AcademicTitleHistory members){
        this.title=title;
        this.memberList=new ArrayList<>(Collections.singletonList(members));
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AcademicTitleHistory> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<AcademicTitleHistory> memberList) {
        this.memberList = memberList;
        this.memberList.forEach(member->member.setAcademicTitle(this));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return title;
    }
}
