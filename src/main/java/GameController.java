import model.Bataille;

import model.ship.Ship;

import javax.swing.*;

import java.awt.*;


import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


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
                if(model.checkPos(toPos,1)) {
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
                    List<Object> temp = model.getAi().play();
                    ((DrawPanel) ((MainFrame) mainFrame).getPanel()).addToHistoryIA((model.ship.Point)(temp.get(1)), (Boolean)temp.get(0));
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
            try {
                int x = mainFrame.getMousePosition().x / 30;
                int y = mainFrame.getMousePosition().y / 30;
                toPos.setPos(new model.ship.Point(x, y));
            }catch (Exception ex){
                System.out.println("Erreur placement bateau");
            }
        }
    }


    public void verifEnd(){
        if(model.isGameover()){
            System.exit(0);
        }
    }
}
