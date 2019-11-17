package model.ship;

public class EraFactoryXX implements EraFactory {
    @Override
    public Ship createShip() {
        return new Croiseur();
    }
}
