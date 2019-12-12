import model.Bataille;

import model.ship.Ship;

import javax.swing.*;

import java.awt.*;


import java.awt.event.*;



public class GameController implements MouseMotionListener, MouseListener{
    public static int INIT_X = 300;
    public static int INIT_Y = 0;
    public static int MAX_HEIGHT = 10;
    public static int MAX_WIDTH = 10;
    private JPanel mainFrame;
    private Bataille model;
    private boolean shipleft;

    private Ship toPos;


    public GameController(JPanel mainFrame, Bataille model){
        super();
        this.mainFrame=mainFrame;
        mainFrame.addMouseListener(this);
        mainFrame.addMouseMotionListener(this);
        this.model = model;
        shipleft=true;

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point p = mainFrame.getMousePosition();
        int x = (p.x - INIT_X)/30;
        int y = (p.y - INIT_Y)/30;

        //placement des bateaux
        if(e.getButton()==1) {
            if (shipleft) {
                //System.out.println(checkPos(toPos));
                if(checkPos(toPos)) {
                    if (model.getFactory().hasNextShip()) {
                        toPos = model.getFactory().getNextShip();
                        model.addShip(toPos);
                    } else {
                        shipleft = false;
                    }
                }


            } else {
                if (p.y / 30 < MAX_HEIGHT && p.x > INIT_X) {
                    model.ship.Point target = new model.ship.Point(x, y);
                    boolean touched = model.shoot(target);
                    ((DrawPanel) ((MainFrame) mainFrame).getPanel()).addToHistory(target, touched);
                    verifEnd();
                    model.getAi().play();
                    verifEnd();
                }
            }
        }else if(e.getButton()==3){
            if(shipleft && toPos!=null){
                toPos.switchDirection();
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(shipleft && toPos!=null){
            int x = mainFrame.getMousePosition().x/30;
            int y = mainFrame.getMousePosition().y/30;
            toPos.setPos(new model.ship.Point(x,y));
        }
    }

    public boolean checkPos(Ship s){
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
        return x>=0 && xbis >=0 && y >=0 && ybis>=0 && x<=10 && xbis <=10 && y<=10 && ybis <=10;
    }

    public void verifEnd(){
        if(model.isGameover()){
            System.exit(0);
        }
    }
}
