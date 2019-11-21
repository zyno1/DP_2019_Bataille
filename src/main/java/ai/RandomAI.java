package ai;

import model.Bataille;
import model.ship.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAI implements AI {
    private List<Point> pos;
    private Bataille model;

    public RandomAI(Bataille model){
        pos = new ArrayList();
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                pos.add(new Point(i,j));
            }
        }
        this.model=model;
    }

    @Override
    public void play() {
        Random rd = new Random();
        int nb = rd.nextInt(pos.size()-1);
        model.shoot(pos.get(nb));
        pos.remove(nb);
    }
}
