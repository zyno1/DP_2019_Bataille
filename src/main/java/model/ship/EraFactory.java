package model.ship;

public interface EraFactory {
    public void createShips();
    public Ship getNextShip();
    public boolean hasNextShip();
}
