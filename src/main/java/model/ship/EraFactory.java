package model.ship;

public interface EraFactory {
    public Ship createShip(Point p, int direction);
    public Ship createShortShip(Point p, int direction);
}
