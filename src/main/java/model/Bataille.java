package model;

import ai.AI;
import ai.RandomAI;
import model.ship.EraFactory;
import model.ship.Point;

import java.awt.image.BufferedImage;

public class Bataille {
    private EraFactory factory;
    private Map player1;
    private Map player2;
    private int playerTurn;
    private AI ai;

    public Bataille(EraFactory factory) {
        this.factory = factory;

        player1 = new Map();
        player2 = new Map();
        playerTurn = 1;

        player1.addShip(factory.createShip(new Point(1, 3)));
        player2.addShip(factory.createShip(new Point(2,5)));
        ai = new RandomAI(this);
    }

    public AI getAi(){
        return ai;
    }

    public boolean shoot(Point target){
        Map mapTargeted;
        if(playerTurn == 1){
            mapTargeted = player2;
            playerTurn = 2;
        }
        else
        {
            mapTargeted = player1;
            playerTurn = 1;
        }

        return mapTargeted.shoot(target);
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
        boolean gameover = false;
        if(player1.isEmpty() || player2.isEmpty()){
            gameover=true;
        }
        return gameover;
    }
}
