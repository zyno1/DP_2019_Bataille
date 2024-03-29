import javax.swing.*;
import java.awt.*;

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
