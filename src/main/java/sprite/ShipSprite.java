package sprite;

import java.awt.image.BufferedImage;

public class ShipSprite {
    private BufferedImage sprite0;
    private BufferedImage sprite1;

    public ShipSprite(BufferedImage sprite0, BufferedImage sprite1){
        this.sprite0=sprite0;
        this.sprite1=sprite1;
    }

    public BufferedImage getSprite0() {
        return sprite0;
    }

    public BufferedImage getSprite1(){
        return sprite1;
    }
}
