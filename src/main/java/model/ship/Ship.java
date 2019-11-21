package model.ship;

import java.awt.image.BufferedImage;

public interface Ship {
    void draw(BufferedImage img, int cell_size);
    int getWidth();
    int getHeight();
    Point getPos();
    void takeDammage(Point p);
    int getLife();
}
