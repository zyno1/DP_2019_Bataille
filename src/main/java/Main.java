import model.Bataille;
import model.ship.EraFactoryXX;
import model.ship.Point;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bataille model = new Bataille(new EraFactoryXX());
        DrawPanel panel = new DrawPanel(model);
        MainFrame mf = new MainFrame(panel);
        GameController gc = new GameController(mf, model);


        while(true) {
            panel.draw();
            mf.repaint();
            Thread.sleep(100);
        }
    }
}
