package model.ship;

public class EraFactoryXVII implements EraFactory {
    @Override
    public Ship createShip(Point p, int direction) {
        return new Galion(p,direction);
    }
}
