package model;

import ai.AI;
import ai.RandomAI;
import model.ship.EraFactory;
import model.ship.EraFactoryXVII;
import model.ship.EraFactoryXX;
import model.ship.Point;

import java.awt.image.BufferedImage;

public class Bataille {
    private EraFactory factory;
    private Map player1;
    private Map player2;
    private int playerTurn;
    private AI ai;
    private String era;

    public Bataille() {

        player1 = new Map();
        player2 = new Map();
        playerTurn = 1;
        era = "temp";

    }

    public Bataille(EraFactory factory) {
        this.factory = factory;

        player1 = new Map();
        player2 = new Map();
        playerTurn = 1;

        player1.addShip(factory.createShip(new Point(1, 3), 1));
        player2.addShip(factory.createShip(new Point(2,5), 1));
        ai = new RandomAI(this);
    }

    public Bataille(String era, String aiPattern, String name) {

        if(era.equals("XX")) {
            this.factory = new EraFactoryXX();
        }

        if(era.equals("XVII")) {
            this.factory = new EraFactoryXVII();
        }

        player1 = new Map();
        player2 = new Map();
        playerTurn = 1;

        player1.addShip(factory.createShip(new Point(1,3), 1));
        player2.addShip(factory.createShip(new Point(2,5), 1));
        player2.addShip(factory.createShip(new Point(5,3), 1));
        ai = new RandomAI(this);

    }

    public void setUp(String era, String aiPattern, String name) {
        if(era.equals("XX")) {
            this.factory = new EraFactoryXX();
            this.era = era;
        }

        if(era.equals("XVII")) {
            this.factory = new EraFactoryXVII();
            this.era = era;
        }

        player2.addShip(factory.createShip(new Point(2,5), 1));
        player2.addShip(factory.createShortShip(new Point(5,3), 2));
        ai = new RandomAI(this);
    }

    public void addShip(Point point, int direction, int type) {
        if(type == 1) {
            player1.addShip(factory.createShip(point, direction));
        }else{
            player1.addShip(factory.createShortShip(point, direction));
        }
    }

    public AI getAi(){
        return ai;
    }

    public String getEra() { return era;}

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


        player1.draw(img);
//        player2.draw(right);
    }

    public boolean isGameover() {
        boolean gameover = false;
        if(player1.isEmpty() || player2.isEmpty()){
            gameover=true;
        }
        return gameover;
    }
}
