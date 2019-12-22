package model.ship;

import sprite.SpriteFactory;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EraFactoryXX implements EraFactory {
    private Iterator<Ship> ships;
    private BufferedImage mapSprite;


    public EraFactoryXX(){
        createShips();
        this.mapSprite= SpriteFactory.getInstance().getMapXX();
    }

    @Override
    public void createShips() {
        ArrayList list=new ArrayList<>();
        list.add(new Croiseur(new Point(0,0),0));
        list.add(new Croiseur(new Point(0,0),0));
        list.add(new SousMarin(new Point(0,0),0));
        list.add(new SousMarin(new Point(0,0),0));
        ships = list.iterator();
    }

    @Override
    public Ship getNextShip() {
        if(ships.hasNext()){
            return ships.next();
        }
        return null;
    }

    @Override
    public boolean hasNextShip() {
        return ships.hasNext();
    }

    @Override
    public BufferedImage getMap() {
        return mapSprite;
    }
}
