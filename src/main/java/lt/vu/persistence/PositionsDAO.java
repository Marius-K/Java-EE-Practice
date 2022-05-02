package lt.vu.persistence;

import lt.vu.entities.Position;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PositionsDAO {
    @Inject
    private EntityManager entityManager;

    public List<Position> getAll() {
        return entityManager.createNamedQuery("Position.getAll", Position.class).getResultList();
    }

    public void save(Position position) {
        entityManager.persist(position);
    }
}
