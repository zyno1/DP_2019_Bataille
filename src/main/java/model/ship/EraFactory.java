package model.ship;

import java.awt.image.BufferedImage;

public interface EraFactory {
    public void createShips();
    public Ship getNextShip();
    public boolean hasNextShip();
    public BufferedImage getMap();
}
