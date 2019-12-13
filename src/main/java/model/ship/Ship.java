package model.ship;

import java.awt.image.BufferedImage;

public interface Ship extends Cloneable{
    void draw(BufferedImage img, int cell_size);
    int getWidth();
    int getHeight();
    Point getPos();
    void setPos(Point pos);
    void takeDammage(Point p);
    int getLife();
    void switchDirection();
    int getDirection();
    Ship getInstance(Point p, int direction);
}
