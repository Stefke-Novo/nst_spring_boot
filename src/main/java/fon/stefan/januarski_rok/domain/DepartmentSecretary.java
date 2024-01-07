package fon.stefan.januarski_rok.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "department_secretary_history")
public class DepartmentSecretary {

    @Id
    private long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "department_id", referencedColumnName = "department_id"),
            @JoinColumn(name = "member_id", referencedColumnName = "id")
    })
    private Member member;


}
