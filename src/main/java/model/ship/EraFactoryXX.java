package model.ship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EraFactoryXX implements EraFactory {
    private Iterator<Ship> ships;


    public EraFactoryXX(){
        createShips();
    }

    /*@Override
    public Ship createShip(Point p, int direction) {
        return new Croiseur(p,direction);
    }

    @Override
    public Ship createShortShip(Point p, int direction) {
        return new SousMarin(p,direction);
    }*/

    @Override
    public void createShips() {
        ArrayList list=new ArrayList<>();
        list.add(new Croiseur(new Point(0,0),0));
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
}
