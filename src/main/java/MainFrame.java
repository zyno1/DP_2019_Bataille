import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel panel;

    public MainFrame(JPanel panel) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.panel = panel;
        setContentPane(panel);
        setVisible(true);
        pack();
        panel.requestFocus();
    }
}
