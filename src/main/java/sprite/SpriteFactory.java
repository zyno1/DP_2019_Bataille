package sprite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteFactory {
    private BufferedImage mapXX;
    private BufferedImage mapXVII;
    private ShipSprite croiseur;
    private ShipSprite sousMarin;
    private ShipSprite vieuxSousMarin;
    private ShipSprite gallion;

    private static SpriteFactory instance = new SpriteFactory();

    private SpriteFactory(){
        try {
            mapXX = ImageIO.read(new File("assets/sea.png"));
            mapXVII = ImageIO.read(new File("assets/sea.png"));
            BufferedImage croiseur0 = ImageIO.read(new File("assets/croiseurXX-0.png"));
            BufferedImage croiseur1 = ImageIO.read(new File("assets/croiseurXX-1.png"));
            BufferedImage sousMarin0 = ImageIO.read(new File("assets/sous-marinXX-0.png"));
            BufferedImage sousMarin1 = ImageIO.read(new File("assets/sous-marinXX-1.png"));
            BufferedImage vieuxSousMarin0 = ImageIO.read(new File("assets/sous-marinXVII-0.png"));
            BufferedImage vieuxSousMarin1 = ImageIO.read(new File("assets/sous-marinXVII-1.png"));
            BufferedImage gallion0 = ImageIO.read(new File("assets/gallion-0.png"));
            BufferedImage gallion1 = ImageIO.read(new File("assets/gallion-1.png"));


            croiseur = new ShipSprite(croiseur0, croiseur1);
            sousMarin= new ShipSprite(sousMarin0,sousMarin1);
            vieuxSousMarin = new ShipSprite(vieuxSousMarin0,vieuxSousMarin1);
            gallion = new ShipSprite(gallion0,gallion1);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static SpriteFactory getInstance(){
        return instance;
    }

    public BufferedImage getMapXX() {
        return mapXX;
    }

    public BufferedImage getMapXVII() {
        return mapXVII;
    }

    public ShipSprite getCroiseur() {
        return croiseur;
    }

    public ShipSprite getSousMarin() {
        return sousMarin;
    }

    public ShipSprite getVieuxSousMarin(){ return vieuxSousMarin;}

    public ShipSprite getGallion() { return gallion; }
}

