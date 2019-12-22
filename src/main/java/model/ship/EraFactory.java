package model.ship;

import java.awt.image.BufferedImage;

public interface EraFactory {
    void createShips();
    Ship getNextShip();
    boolean hasNextShip();
    BufferedImage getMap();
}
