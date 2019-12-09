package model.ship;

import java.util.ArrayList;
import java.util.List;

public class EraFactoryXX implements EraFactory {

    private List<Ship> lesBateaux;

    public EraFactoryXX() {

        lesBateaux = new ArrayList<>();



    }

    @Override
    public Ship createShip(Point p, int direction) {
        return new Croiseur(p,direction);
    }

    @Override
    public Ship createShortShip(Point p, int direction) {
        return new SousMarin(p,direction);
    }

    @Override
    public Ship getNextShip() {
        return null;
    }
}
