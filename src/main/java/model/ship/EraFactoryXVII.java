package model.ship;

import sprite.SpriteFactory;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

public class EraFactoryXVII implements EraFactory {

    private Iterator<Ship> ships;

    private BufferedImage mapSprite;

    public EraFactoryXVII(){
        createShips();
        mapSprite= SpriteFactory.getInstance().getMapXVII();
    }

    @Override
    public void createShips() {
        ArrayList<Ship> list=new ArrayList<>();
        list.add(new Galion(new Point(0,0),0));
        list.add(new Galion(new Point(0,0),0));
        list.add(new VieuxSousMarin(new Point(0,0),0));
        list.add(new VieuxSousMarin(new Point(0,0),0));
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
