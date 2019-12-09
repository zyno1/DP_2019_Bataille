import model.Bataille;
import model.ship.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class DrawPanel extends JPanel {
    private static int SIZE = 10;

    private BufferedImage currentFrame;
    private BufferedImage nextFrame;

    private Bataille game;

    private HashMap<Point, Boolean> history;

    public DrawPanel(Bataille game) {
        setSize(600, 400);
        setFocusable(true);
        this.game = game;

        currentFrame = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        nextFrame = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        this.history=new HashMap<>();
    }

    public void draw() {
        Graphics g = nextFrame.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        int w = nextFrame.getWidth() - 20;
        int h = nextFrame.getHeight() - 10;

        BufferedImage left = nextFrame.getSubimage(5, 5, w / 2, h);
        BufferedImage right = nextFrame.getSubimage(10 + w / 2, 5, w / 2, h);

        game.draw(left);
        drawHistory(right);


        BufferedImage tmp = currentFrame;
        currentFrame = nextFrame;
        nextFrame = tmp;

        repaint();
    }


    public void addToHistory(Point p, boolean b){
        if(!history.containsKey(p)){
            history.put(p, b);
        }
    }

    public void drawHistory(BufferedImage img) {

        Graphics g = img.getGraphics();

        int cell_size = Math.min(img.getHeight(), img.getWidth()) / SIZE;

        g.setColor(Color.BLUE);
        g.fillRect(0, 0, cell_size * SIZE, cell_size * SIZE);

        g.setColor(Color.BLACK);

        for(int i = 0; i <= SIZE; i++) {
            g.drawLine(i * cell_size, 0, i * cell_size, cell_size * SIZE);
            g.drawLine(0, i * cell_size, cell_size * SIZE, i * cell_size);
        }


        for(Map.Entry<model.ship.Point, Boolean> entry : history.entrySet()){
            int x = entry.getKey().getX();
            int y = entry.getKey().getY();
            if(entry.getValue()){
                if(game.getEra().equals("XX")) {
                    g.setColor(Color.GREEN);
                }else{
                    g.setColor(Color.YELLOW);
                }
            }else{
                g.setColor(Color.RED);
            }
            g.fillRect(x*cell_size, y*cell_size, cell_size, cell_size);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.printComponent(g);

        g.drawImage(this.currentFrame, 0, 0, getWidth(), getHeight(), 0, 0,
                getWidth(), getHeight(), null);
    }
}
