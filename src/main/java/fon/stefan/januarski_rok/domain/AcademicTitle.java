package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "academic_title")
public class AcademicTitle {
    @Id
    private long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "academicTitle")
    List<Member> memberList;
}
