package model;

import model.ship.Point;
import model.ship.Ship;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Map {
    private static int SIZE = 10;

    private Collection<Ship> ships;

    private BufferedImage mapSprite;

    public Map(BufferedImage mapSprite) {
        ships = new ArrayList<>();
        this.mapSprite=mapSprite;
    }

    public void addShip(Ship s) {
        ships.add(s);
    }

    public boolean isEmpty(){
        return ships.isEmpty();
    }

    public void draw(BufferedImage img) {
        Graphics g = img.getGraphics();

        int cell_size = Math.min(img.getHeight(), img.getWidth()) / SIZE;

        g.drawImage(mapSprite, 0,0, cell_size*SIZE, cell_size*SIZE, null);

        g.setColor(Color.BLACK);

        for(int i = 0; i <= SIZE; i++) {
            g.drawLine(i * cell_size, 0, i * cell_size, cell_size * SIZE);
            g.drawLine(0, i * cell_size, cell_size * SIZE, i * cell_size);
        }

        for(Ship s : ships) {
            s.draw(img, cell_size);
        }
    }

    public boolean shoot(Point target){
        for(Ship s : ships){
            Point p = s.getPos();
            int h = s.getHeight();
            int w = s.getWidth();

            if(s.getDirection() == 0) {
                h = s.getWidth();
                w = s.getHeight();
            }

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    int x = p.getX()+j;
                    int y = p.getY()+i;
                    if(target.getX()==x && target.getY()==y){
                        s.takeDammage(target);
                        if(s.getLife()<=0) ships.remove(s);
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public Collection<Ship> getShips() {
        return ships;
    }
}
