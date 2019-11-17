package model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Map {
    private static int SIZE = 10;

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
    }
}
