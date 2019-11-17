package model;

import model.ship.EraFactory;
import model.ship.Point;

import java.awt.image.BufferedImage;

public class Bataille {
    private boolean gameover;
    private EraFactory factory;
    private Map player1;
    private Map player2;

    public Bataille(EraFactory factory) {
        this.gameover = false;
        this.factory = factory;

        player1 = new Map();
        player2 = new Map();

        player1.addShip(factory.createShip(new Point(1, 3)));
    }

    public void draw(BufferedImage img) {
        int w = img.getWidth() - 20;
        int h = img.getHeight() - 10;

        BufferedImage left = img.getSubimage(5, 5, w / 2, h);
        BufferedImage right = img.getSubimage(10 + w / 2, 5, w / 2, h);

        player1.draw(left);
        player2.draw(right);
    }

    public boolean isGameover() {
        return gameover;
    }
}
