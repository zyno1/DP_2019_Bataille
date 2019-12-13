package model.ship;

public class EraFactoryXVII implements EraFactory {
    /*@Override
    public Ship createShip(Point p, int direction) {
        return new Galion(p,direction);
    }

    @Override
    public Ship createShortShip(Point p, int direction) {
        return new VieuxSousMarin(p,direction);
    }
*/
    @Override
    public void createShips() {

    }

    @Override
    public Ship getNextShip() {
        return null;
    }

    @Override
    public boolean hasNextShip() {
        return false;
    }
}
