import model.Bataille;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GameController implements MouseListener {
    public static int INIT_X = 300;
    public static int INIT_Y = 0;
    private JPanel mainFrame;
    private Bataille model;

    public GameController(JPanel mainFrame, Bataille model){
        super();
        this.mainFrame=mainFrame;
        mainFrame.addMouseListener(this);
        this.model = model;
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
        model.ship.Point target = new model.ship.Point(x,y);
        boolean touched = model.shoot(target);
        ((DrawPanel)((MainFrame)mainFrame).getPanel()).addToHistory(target, touched);
        verifEnd();
        model.getAi().play();
        verifEnd();
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
