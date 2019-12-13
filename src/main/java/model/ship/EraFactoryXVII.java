package model.ship;

import java.util.ArrayList;
import java.util.Iterator;

public class EraFactoryXVII implements EraFactory {

    private Iterator<Ship> ships;

    public EraFactoryXVII(){
        createShips();
    }

    /*@Override
    public Ship createShip(Point p, int direction) {
        return new Galion(p,direction);
    }

    @Override
    public Ship createShortShip(Point p, int direction) {
        return new VieuxSousMarin(p,direction);
    }
*/
    @Override
    public void createShips() {
        ArrayList list=new ArrayList<>();
        list.add(new Galion(new Point(0,0),0));
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
}
