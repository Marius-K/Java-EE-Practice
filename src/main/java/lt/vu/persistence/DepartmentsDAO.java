package lt.vu.persistence;

import lombok.Setter;
import lt.vu.entities.Department;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class DepartmentsDAO {
    @Inject
    @Setter
    private EntityManager entityManager;

    public List<Department> getAll() {
        return entityManager.createNamedQuery("Department.getAll", Department.class).getResultList();
    }

    public Department find(Integer id) {
        return entityManager.find(Department.class, id);
    }

    public void save(Department department) {
        entityManager.persist(department);
    }
}
