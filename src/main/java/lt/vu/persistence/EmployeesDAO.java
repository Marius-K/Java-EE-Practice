package lt.vu.persistence;

import lt.vu.entities.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class EmployeesDAO {
    @Inject
    private EntityManager entityManager;

    public List<Employee> getAll() {
        return entityManager.createNamedQuery("Employee.getAll", Employee.class).getResultList();
    }

    public Employee find(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    public void create(Employee employee) {
        entityManager.persist(employee);
    }

    public Employee update(Employee employee){
        return entityManager.merge(employee);
    }
}
