import model.ship.Point;
import model.ship.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainFrame extends JPanel {


    private JPanel panel;
    private BorderLayout borderLayout;


    public MainFrame(JPanel panel) {

        borderLayout = new BorderLayout();
        this.setLayout(borderLayout);


        this.panel = panel;
        this.add(panel, BorderLayout.CENTER);

        panel.requestFocus();
        this.setPreferredSize(new Dimension(600,400));


    }

    public JPanel getPanel(){
        return panel;
    }
}
