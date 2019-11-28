package model.ship;

public class EraFactoryXVII implements EraFactory {
    @Override
    public Ship createShip(Point p) {
        return new Galion(p);
    }
}
