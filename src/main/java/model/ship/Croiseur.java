package model.ship;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Croiseur implements Ship {
    private int w = 1;
    private int h = 4;

    private Point pos;

    public Croiseur(Point pos) {
        this.pos = pos;
    }

    @Override
    public void draw(BufferedImage img, int cell_size) {
        Graphics g = img.getGraphics();

        g.setColor(Color.GREEN);
        g.fillRect(pos.getX() * cell_size, pos.getY() * cell_size, w * cell_size, h * cell_size);
    }

    @Override
    public int getWidth() {
        return w;
    }

    @Override
    public int getHeight() {
        return h;
    }

    @Override
    public Point getPos() {
        return pos;
    }
}
