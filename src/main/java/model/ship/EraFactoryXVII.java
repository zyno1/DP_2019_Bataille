package model.ship;

import java.util.ArrayList;
import java.util.List;

public class EraFactoryXVII implements EraFactory {

    private List<Ship> lesBateaux;

    public EraFactoryXVII() {

        lesBateaux = new ArrayList<>();

    }

    @Override
    public Ship createShip(Point p, int direction) {
        return new Galion(p,direction);
    }

    @Override
    public Ship createShortShip(Point p, int direction) {
        return new VieuxSousMarin(p,direction);
    }

    @Override
    public Ship getNextShip() {
        return null;
    }
}
