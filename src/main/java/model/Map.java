package model;

import model.ship.Ship;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Map {
    private static int SIZE = 10;

    private Collection<Ship> ships;

    public Map() {
        ships = new ArrayList<>();
    }

    public void addShip(Ship s) {
        ships.add(s);
    }

    public void draw(BufferedImage img) {
        Graphics g = img.getGraphics();

        int cell_size = Math.min(img.getHeight(), img.getWidth()) / SIZE;

        g.setColor(Color.BLUE);
        g.fillRect(0, 0, cell_size * SIZE, cell_size * SIZE);

        g.setColor(Color.BLACK);

        for(int i = 0; i <= SIZE; i++) {
            g.drawLine(i * cell_size, 0, i * cell_size, cell_size * SIZE);
            g.drawLine(0, i * cell_size, cell_size * SIZE, i * cell_size);
        }

        for(Ship s : ships) {
            s.draw(img, cell_size);
        }
    }
}
