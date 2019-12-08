import model.Bataille;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;


public class GameController implements MouseListener {
    public static int INIT_X = 300;
    public static int INIT_Y = 0;
    public static int MAX_HEIGHT = 10;
    public static int MAX_WIDTH = 10;
    private JPanel mainFrame;
    private Bataille model;
    private int shipleft;
    private int shiptype = 1; //1 croiseur, 2 sousmarin
    private model.ship.Point first = null;
    private model.ship.Point second = null;


    public GameController(JPanel mainFrame, Bataille model){
        super();
        this.mainFrame=mainFrame;
        mainFrame.addMouseListener(this);
        this.model = model;
        shipleft = 2;
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
        if(shipleft>0) {
            if(p.x/30 < INIT_X/30 && p.y/30 < MAX_HEIGHT) {
                if (first == null) {
                    first = new model.ship.Point(p.x/30, p.y/30);
                }else if(second == null) {
                    second = new model.ship.Point(p.x/30, p.y/30);
                    int a = second.getX() - first.getX();
                    int b = second.getY() - first.getY();
                    if(a > 0 && a > b) {
                        model.addShip(new model.ship.Point(first.getX(), first.getY()), 2, shiptype); //left
                        shipleft--;
                        shiptype++;
                        first = null;
                        second = null;
                    }else {
                        model.addShip(new model.ship.Point(first.getX(), first.getY()), 1, shiptype); //down
                        shipleft--;
                        shiptype++;
                        first = null;
                        second = null;
                    }
                }
            }

        }else{
            if(p.y/30 < MAX_HEIGHT && p.x/30 > INIT_X/30) {
                model.ship.Point target = new model.ship.Point(x, y);
                boolean touched = model.shoot(target);
                ((DrawPanel) ((MainFrame) mainFrame).getPanel()).addToHistory(target, touched);
                verifEnd();
                model.getAi().play();
                verifEnd();
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void verifEnd(){
        if(model.isGameover()){
            System.exit(0);
        }
    }


}
