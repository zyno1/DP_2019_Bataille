package ai;

import model.Bataille;
import model.ship.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CrossAI implements AI{
    private List<Point> pos;
    private Bataille model;

    private List<Point> nexts;

    public CrossAI(Bataille model){
        pos = new ArrayList<>();
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                pos.add(new Point(i,j));
            }
        }
        this.model=model;

        this.nexts = new ArrayList<>();
    }

    @Override
    public List<Object> play() {
        List<Object> temp = new ArrayList<>();
        Point target;
        if(nexts.isEmpty()){
            Random rd = new Random();
            int nb = rd.nextInt(pos.size()-1);
            target = pos.get(nb);
        }else{
            target = nexts.get(0);
            nexts.remove(target);
        }
        boolean touched = model.shoot(target);
        temp.add(touched);
        temp.add(target);
        pos.remove(target);
        if(touched){
            majNext(target);
        }

        return temp;
    }


    private void majNext(Point last){
        for(Point p : pos){
            int manhatthanDist = Math.abs(p.getX()-last.getX())+Math.abs(p.getY()-last.getY());
            if(manhatthanDist==1){
                nexts.add(p);
            }
        }
    }
}
