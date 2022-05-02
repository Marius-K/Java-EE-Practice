package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Position.getAll", query = "select p from Position as p")
})
@Table(name = "POSITION")
@Getter
@Setter
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @ManyToMany
    @JoinTable(name="EMPLOYEE_POSITION")
    private List<Employee> employees;
}
