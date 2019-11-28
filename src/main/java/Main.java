import model.Bataille;
import model.ship.EraFactoryXX;
import model.ship.Point;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

//        Bataille model = new Bataille(new EraFactoryXX());
//        DrawPanel panel = new DrawPanel(model);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainMenu mm = new MainMenu();
//        MainFrame mf = new MainFrame(panel);

        frame.add(mm, BorderLayout.CENTER);

//        GameController gc = new GameController(mf, model);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(650,450);


        while(true) {
            mm.updateFrame();
//            panel.draw();
//            mf.repaint();
//            Thread.sleep(100);
        }
    }
}
