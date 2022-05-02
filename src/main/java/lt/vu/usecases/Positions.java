package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Position;
import lt.vu.persistence.PositionsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Positions {
    @Inject
    private PositionsDAO positionsDAO;

    @Getter
    @Setter
    private Position newPosition = new Position();

    @Getter
    private List<Position> positionList;

    @PostConstruct
    public void init() {
        loadPositions();
    }

    @Transactional
    public void createPosition(){
        positionsDAO.save(newPosition);
    }

    private void loadPositions(){
        this.positionList = positionsDAO.getAll();
    }
}
