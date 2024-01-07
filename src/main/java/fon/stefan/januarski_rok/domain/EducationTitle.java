package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "education_title")
public class EducationTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String title;

    @OneToMany(mappedBy = "educationTitle")
    List<Member> members;
}
