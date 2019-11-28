import model.Bataille;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {

    private BufferedImage currentFrame;
    private BufferedImage nextFrame;

    private Bataille game;

    public DrawPanel(Bataille game) {
        setSize(600, 400);
        setFocusable(true);
        this.game = game;

        currentFrame = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        nextFrame = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    public void draw() {
        Graphics g = nextFrame.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        game.draw(nextFrame);

        BufferedImage tmp = currentFrame;
        currentFrame = nextFrame;
        nextFrame = tmp;

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.printComponent(g);

        g.drawImage(this.currentFrame, 0, 0, getWidth(), getHeight(), 0, 0,
                getWidth(), getHeight(), null);
    }
}
