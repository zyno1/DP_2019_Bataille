import model.Bataille;
import model.ship.EraFactoryXX;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bataille model = new Bataille(new EraFactoryXX());
        DrawPanel panel = new DrawPanel(model);
        MainFrame mf = new MainFrame(panel);

        while(true) {
            panel.draw();
            mf.repaint();

            Thread.sleep(100);
        }
    }
}
