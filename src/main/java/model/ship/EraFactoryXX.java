package model.ship;

public class EraFactoryXX implements EraFactory {
    @Override
    public Ship createShip(Point p, int direction) {
        return new Croiseur(p,direction);
    }

    @Override
    public Ship createShortShip(Point p, int direction) {
        return new SousMarin(p,direction);
    }
}
