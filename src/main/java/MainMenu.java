import model.Bataille;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends JPanel implements ActionListener {

    private BorderLayout borderLayout;

    private GameController gc;
    private DrawPanel drawPanel;
    private MainFrame mf;

    private JPanel gamePanel;
    private JPanel menuPanel;
    private JPanel choicePanel;
    private JPanel scorePanel;

    private JLabel scoreJoueur1;
    private JLabel scoreJoueur2;
    private JLabel test;
    private JTextField playerName;

    private String era;
    private String ai;
    private String name = "";

    private Bataille model;

    private JButton tempEra = null;
    private JButton tempAi = null;

    public MainMenu() {

        borderLayout = new BorderLayout();
        this.setLayout(borderLayout);

        menuPanel = new JPanel();
        JButton button = new JButton("New Game");
        button.setActionCommand("New Game");
        button.addActionListener(this);
        menuPanel.add(button);


        this.add(menuPanel, BorderLayout.CENTER);
//        menuPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        era = "XX";
        ai = "Random";
        mainGame();
        newGame();
        score();

    }

    public void mainGame() {
        model = new Bataille();
        gamePanel = new JPanel();


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

        //Panel 1
        JLabel player = new JLabel("Player name :");
        playerName = new JTextField("Ayaya");
        panel1.add(player);
        panel1.add(playerName);

        //Panel 2
        JLabel era = new JLabel("Era : ");

        JButton eraXX = new JButton("XX");
        eraXX.setBackground(Color.WHITE);
        eraXX.addActionListener(this);

        JButton eraXVII = new JButton("XVII");
        eraXVII.addActionListener(this);
        eraXVII.setBackground(Color.WHITE);

        panel2.add(era);
        panel2.add(eraXX);
        panel2.add(eraXVII);

        //Panel 3
        JLabel ai = new JLabel("Ai :");

        JButton aiRandom = new JButton("Random");
        aiRandom.setBackground(Color.WHITE);
        aiRandom.addActionListener(this);

        JButton aiCrossed = new JButton("Crossed");
        aiCrossed.setBackground(Color.WHITE);
        aiCrossed.addActionListener(this);

        panel3.add(ai);
        panel3.add(aiRandom);
        panel3.add(aiCrossed);

        //Final panel
        JButton confirm = new JButton("Confirm");
        confirm.setBackground(Color.WHITE);
        confirm.addActionListener(this);
        panelFinal.add(confirm);

        choicePanel.add(panel1);
        choicePanel.add(panel2);
        choicePanel.add(panel3);
        choicePanel.add(panelFinal);
    }

    public void score() {

        scorePanel = new JPanel();

        JPanel joueur1 = new JPanel();
        joueur1.setLayout(new BoxLayout(joueur1, BoxLayout.Y_AXIS));
        test = new JLabel("Ships left " + model.getName() + ": ");
        scoreJoueur1 = new JLabel(Integer.toString(model.getPlayer1().getShips().size()));
        joueur1.add(test);
        joueur1.add(scoreJoueur1);

        JPanel joueur2 = new JPanel();
        joueur2.setLayout(new BoxLayout(joueur2, BoxLayout.Y_AXIS));
        JLabel test2 = new JLabel("Ships left IA : ");
        scoreJoueur2 = new JLabel(Integer.toString(model.getPlayer2().getShips().size()));
        joueur2.add(test2);
        joueur2.add(scoreJoueur2);

        scorePanel.add(joueur1);
        scorePanel.add(joueur2);


    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getActionCommand().equals("New Game")) {
            for (Component component : getComponents()) {
                if (menuPanel == component) {
                    remove(menuPanel);
                    add(choicePanel, BorderLayout.CENTER);
                }
            }

        }

        if(actionEvent.getActionCommand().equals("XX")){
            era = "XX";
            Object source = actionEvent.getSource();
            ((JButton)source).setBackground(Color.GREEN);
            if(tempEra != null) {
                tempEra.setBackground(Color.WHITE);
            }
            tempEra = (JButton)source;
        }

        if(actionEvent.getActionCommand().equals("XVII")){
            era = "XVII";
            Object source = actionEvent.getSource();
            ((JButton)source).setBackground(Color.YELLOW);
            if(tempEra != null) {
                tempEra.setBackground(Color.WHITE);
            }
            tempEra = (JButton)source;
        }

        if(actionEvent.getActionCommand().equals("Random")){
            ai = "Random";
            Object source = actionEvent.getSource();
            ((JButton)source).setBackground(Color.CYAN);
            if(tempAi != null) {
                tempAi.setBackground(Color.WHITE);
            }
            tempAi = (JButton)source;
        }

        if(actionEvent.getActionCommand().equals("Crossed")){
            ai = "Crossed";
            Object source = actionEvent.getSource();
            ((JButton)source).setBackground(Color.CYAN);
            if(tempAi != null) {
                tempAi.setBackground(Color.WHITE);
            }
            tempAi = (JButton)source;
        }

        if(actionEvent.getActionCommand().equals("Confirm")){
            name = playerName.getText();
            model.setUp(era, ai, name);
            test.setText("Ships left " + model.getName() + ": ");

            updateFrame();
            for (Component component : getComponents()) {
                if (choicePanel == component) {
                    remove(choicePanel);
                    add(gamePanel, BorderLayout.CENTER);
                    add(new MenuBar(this), BorderLayout.NORTH);
                    add(scorePanel, BorderLayout.SOUTH);
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
                remove(scorePanel);
                add(menuPanel, BorderLayout.CENTER);
            }
        }
        mainGame();
        newGame();
        repaint();
        revalidate();
    }


    public void updateFrame() {

        scoreJoueur1.setText(Integer.toString(model.getPlayer1().getShips().size()));
        scoreJoueur2.setText(Integer.toString(model.getPlayer2().getShips().size()));

        drawPanel.draw();
        mf.repaint();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
