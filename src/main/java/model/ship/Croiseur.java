package model.ship;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Croiseur implements Ship {
    private int w = 1;
    private int h = 4;

    private Point pos;
    private int direction;

    private int life;

    public Croiseur(Point pos, int d) {

        this.pos = pos;
        this.direction = d;
        life = 4;

    }

    @Override
    public void draw(BufferedImage img, int cell_size) {
        Graphics g = img.getGraphics();

        g.setColor(Color.GREEN);

        if(direction == 1) {
            g.fillRect(pos.getX() * cell_size, pos.getY() * cell_size, w * cell_size, h * cell_size);
        }else{
            g.fillRect(pos.getX() * cell_size, pos.getY() * cell_size, h * cell_size, w * cell_size);
        }
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

    @Override
    public void setPos(Point pos) {
        this.pos=pos;
    }

    @Override
    public void takeDammage(Point p) {
        life--;
        System.out.println("hp left croiseur : " + life);
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void switchDirection() {
        if(direction==0) direction=1;
        else direction=0;
    }

    @Override
    public Ship getInstance(Point p, int direction) {
        return new Croiseur(p, direction);
    }

    @Override
    public int getDirection(){
        return direction;
    }


}
