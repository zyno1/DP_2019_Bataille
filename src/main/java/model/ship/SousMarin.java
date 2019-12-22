package model.ship;

import sprite.ShipSprite;
import sprite.SpriteFactory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SousMarin implements Ship {
    private int w = 1;
    private int h = 2;

    private Point pos;
    private int direction;

    private ShipSprite sprite;

    private int life;

    public SousMarin(Point pos, int d) {

        this.pos = pos;
        this.direction = d;
        life = 2;

        sprite = SpriteFactory.getInstance().getSousMarin();

    }

    @Override
    public void draw(BufferedImage img, int cell_size) {
        Graphics g = img.getGraphics();


        if(direction == 1) {
            g.drawImage(sprite.getSprite1(), pos.getX() * cell_size, pos.getY() * cell_size, w * cell_size, h*cell_size, null);
        }else{
            g.drawImage(sprite.getSprite0(), pos.getX() *cell_size, pos.getY() *cell_size, h * cell_size, w*cell_size, null);
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
        return new SousMarin(p, direction);
    }

    @Override
    public int getDirection(){
        return direction;
    }


}
