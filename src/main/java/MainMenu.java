import model.Bataille;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel implements ActionListener {

    private BorderLayout borderLayout;

    private GameController gc;
    private DrawPanel drawPanel;
    private MainFrame mf;

    private JPanel gamePanel;
    private JPanel menuPanel;
    private JPanel choicePanel;

    private String era;
    private String ai;
    private String name = "";

    private Bataille model;
    private Boolean created = false;

    public MainMenu() {

        borderLayout = new BorderLayout();
        this.setLayout(borderLayout);

        menuPanel = new JPanel();
        JButton button = new JButton("Nouvelle Partie");
        button.setActionCommand("Nouvelle Partie");
        button.addActionListener(this);
        menuPanel.add(button);


        this.add(menuPanel, BorderLayout.CENTER);
//        menuPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        era = "XX";
        ai = "Random";
        mainGame();
        newGame();

    }

    public void mainGame() {
        gamePanel = new JPanel();

//        Bataille model = new Bataille(new EraFactoryXX());
        drawPanel = new DrawPanel(model);
        mf = new MainFrame(drawPanel);

        gc = new GameController(mf, model);

        gamePanel.setPreferredSize(new Dimension(600, 400));
        gamePanel.add(mf);
//        gamePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

    }

    public void newGame() {

        choicePanel = new JPanel();
        choicePanel.setLayout(new BoxLayout(choicePanel, BoxLayout.Y_AXIS));

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panelFinal = new JPanel();

        JLabel player = new JLabel("Player name :");
        JTextField name = new JTextField("Ayaya");
        panel1.add(player);
        panel1.add(name);

        JLabel era = new JLabel("Era : ");
        JButton eraXX = new JButton("XX");
        eraXX.addActionListener(this);
        JButton eraXVII = new JButton("XVII");
        eraXVII.addActionListener(this);
        panel2.add(era);
        panel2.add(eraXX);
        panel2.add(eraXVII);

        JLabel ai = new JLabel("Ai :");
        JButton aiRandom = new JButton("Random");
        aiRandom.addActionListener(this);
        JButton aiCrossed = new JButton("Crossed");
        aiRandom.addActionListener(this);
        panel3.add(ai);
        panel3.add(aiRandom);
        panel3.add(aiCrossed);

        JButton confirm = new JButton("Confirm");
        confirm.addActionListener(this);
        panelFinal.add(confirm);

        choicePanel.add(panel1);
        choicePanel.add(panel2);
        choicePanel.add(panel3);
        choicePanel.add(panelFinal);



    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getActionCommand().equals("Nouvelle Partie")) {
            for (Component component : getComponents()) {
                if (menuPanel == component) {
                    remove(menuPanel);
                    add(choicePanel, BorderLayout.CENTER);
                }
            }

        }

        if(actionEvent.getActionCommand().equals("XX")){
            era = "XX";
//            System.out.println(era);
        }

        if(actionEvent.getActionCommand().equals("XVII")){
            era = "XVII";
//            System.out.println(era);
        }

        if(actionEvent.getActionCommand().equals("Random")){
            ai = "Random";
        }

        if(actionEvent.getActionCommand().equals("Crossed")){
            ai = "Crossed";
        }

        if(actionEvent.getActionCommand().equals("Confirm")){
            model = new Bataille(era, ai, name);
            mainGame();
            created = true;
            updateFrame();
            for (Component component : getComponents()) {
                if (choicePanel == component) {
                    remove(choicePanel);
                    add(gamePanel, BorderLayout.CENTER);
                    add(new MenuBar(this), BorderLayout.NORTH);
                    System.out.println("test");
                }
            }
        }

        repaint();
        revalidate();

    }


    public void retourMainMenu() {

        for (Component component : getComponents()) {
            if (gamePanel == component) {
                remove(gamePanel);
                add(menuPanel, BorderLayout.CENTER);
            }
        }
        repaint();
        revalidate();
    }


    public void updateFrame() {
        if(created) {

            drawPanel.draw();
            mf.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
