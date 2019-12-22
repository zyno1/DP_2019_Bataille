package model;

import ai.AI;
import ai.CrossAI;
import ai.RandomAI;
import model.ship.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Bataille {
    private EraFactory factory;
    private Map player1;
    private Map player2;
    private int playerTurn;
    private AI ai;
    private String era;
    private String name;
    private int shotNumber;

    public Bataille() {

        player1 = new Map(null);
        player2 = new Map(null);
        playerTurn = 1;
        shotNumber = 0;
        era = "temp";
        name = "temp";
        factory = new EraFactoryXX();

    }

    public Bataille(String era, String aiPattern, String name) {

        if(era.equals("XX")) {
            this.factory = new EraFactoryXX();
        }

        if(era.equals("XVII")) {
            this.factory = new EraFactoryXVII();
        }

        this.name = name;
        player1 = new Map(factory.getMap());
        player2 = new Map(factory.getMap());
        playerTurn = 1;



        if(aiPattern.equals("Random")){
            ai = new RandomAI(this);
        }
        if(aiPattern.equals("Crossed")){
            ai = new CrossAI(this);
        }

    }

    public void setUp(String era, String aiPattern, String name) {

        if(aiPattern.equals("Random")){
            ai = new RandomAI(this);
        }
        if(aiPattern.equals("Crossed")){
            ai = new CrossAI(this);
        }

        if(era.equals("XX")) {
            this.factory = new EraFactoryXX();
            this.era = era;
        }

        if(era.equals("XVII")) {
            this.factory = new EraFactoryXVII();
            this.era = era;
        }

        this.name = name;
        player1 = new Map(factory.getMap());
        player2 = new Map(factory.getMap());
    }

    //a chaque fois qu'on ajoute un bateau au joueur 1, on ajoute un bateau du même type à une position aléatoire pour l'IA
    public void addShip(Ship s){
        player1.addShip(s);
        Random r = new Random();
        int x = r.nextInt(10);
        int y = r.nextInt(10);
        int d = r.nextInt(2);
        Ship s2 = s.getInstance(new Point(x, y), d);
        while(!checkPos(s2,2)) {
            x = r.nextInt(10);
            y = r.nextInt(10);
            s2.setPos(new Point(x, y));
        }
        player2.addShip(s2);

    }

    public AI getAi(){
        return ai;
    }

    public EraFactory getFactory() {
        return factory;
    }

    public String getEra() { return era;}

    //en fonction du joueur actuel, on shoot la map de l'autre joueur
    public boolean shoot(Point target){
        Map mapTargeted;
        if(playerTurn == 1){
            mapTargeted = player2;
            playerTurn = 2;
            shotNumber ++;
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
    }

    //si la partie est terminée, on récupère 1 ou 2 en fonction du joueur qui a gagné
    public int isGameover() {
        int gameover = 0;

        if(player1.isEmpty()) {
            if(!factory.hasNextShip()) {
                gameover = 2;
            }
        }

        if(player2.isEmpty()){
            if(!factory.hasNextShip()) {
                gameover = 1;
            }
        }
        return gameover;
    }

    //Vérifie que le bateau ne puisse pas être placé en dehors de la map
    public boolean checkPos(Ship s, int joueur){
        if(s==null){
            return true;
        }

        model.ship.Point p = s.getPos();
        int x= p.getX();
        int y= p.getY();
        int xbis=x;
        int ybis=y;
        if(s.getDirection()==1){
            ybis = y+s.getHeight();
        }else{
            xbis = x+s.getHeight();
        }

        if(x>=0 && xbis >=0 && y >=0 && ybis>=0 && x<10 && xbis <=10 && y<10 && ybis <=10) {
            return checkConflits(s,joueur); //appelle la vérification sur bateau
        }

        return false;
    }

    //Vérifie que deux bateaux ne soient pas l'un sur l'autre
    private boolean checkConflits(Ship s, int joueur) {
        if(s==null){
            return true;
        }

        Map map;

        if(joueur == 1)  {
            map = player1;
        }else{
            map = player2;
        }

        ArrayList<Point> aya = new ArrayList<>();

        model.ship.Point point = s.getPos();

        //liste des positions du bateau (si le bateau fait 4 de longueur et se trouve en 1,1 en direction 0 alors -> 1,1 ; 2,1 ; 3,1 ; 4,1
        if(s.getDirection() == 1) {
            for(int i = point.getY(); i<point.getY()+s.getHeight(); i++) {
                aya.add(new Point(point.getX(),i));
//                System.out.println(point.getX() + "," + i);
            }
        } else{
            for(int i = point.getX(); i<point.getX()+s.getHeight(); i++) {
                aya.add(new Point(i,point.getY()));
//                System.out.println(i + "," + point.getY());
            }
        }


        for(Point p : aya) {
            for (Ship ship : map.getShips()) {

                if(ship != s) {

                    Point temp = ship.getPos();
                    int h = ship.getHeight();
                    int w = ship.getWidth();

                    if (ship.getDirection() == 0) {
                        h = ship.getWidth();
                        w = ship.getHeight();
                    }

                    for (int i = 0; i < h; i++) {
                        for (int j = 0; j < w; j++) {
                            int a = temp.getX() + j;
                            int b = temp.getY() + i;
                            if (p.getX() == a && p.getY() == b) {
                                //conflit
                                return false;
                            }

                        }
                    }
                }

            }
        }

        return true;

    }

    public Map getPlayer1() {
        return player1;
    }

    public Map getPlayer2() {
        return player2;
    }

    public String getName() {
        return name;
    }

    public int getShotNumber() {
        return shotNumber;
    }
}
