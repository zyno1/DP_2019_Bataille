import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainMenu mm = new MainMenu();

        frame.add(mm, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(650,410);


        while(true) {
            mm.updateFrame();
        }
    }
}
