package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
    @NamedQuery(name = "Employee.getAll", query = "select e from Employee as e")
})
@Table(name = "EMPLOYEE")
@Getter
@Setter
public class Employee implements Serializable {
    public Employee() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Size(max = 50)
    @Column(name = "LAST_NAME")
    private String lastName;

    @Size(max = 50)
    @Column(name = "LOGIN_NAME", unique = true)
    private String loginName;

    @ManyToOne
    @JoinColumn(name="DEPARTMENT_ID")
    private Department department;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    @ManyToMany(mappedBy = "employees", fetch = FetchType.EAGER)
    private List<Position> positions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
