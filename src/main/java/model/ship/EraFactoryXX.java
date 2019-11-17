package model.ship;

public class EraFactoryXX implements EraFactory {
    @Override
    public Ship createShip(Point p) {
        return new Croiseur(p);
    }
}
