package Tests;

import model.Bataille;
import model.ship.Croiseur;
import model.ship.Point;
import model.ship.Ship;
import model.ship.SousMarin;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BatailleTest {

    private Bataille bataille;

    @Test
    void shoot() { //tir sur la map du joueur qui ne joue pas
        bataille = new Bataille();
        bataille.setUp("XX", "Crossed", "temp");
        bataille.addShip(new Croiseur(new Point(1,1), 0)); //croiseur taille 4 en largeur position 1,1
        bataille.addShip(new SousMarin(new Point(5,4), 1)); //sousmarin taille 2 en hauteur position 5,4

        bataille.shoot(new Point(2,2));
        assertTrue(bataille.shoot(new Point(3,1)));
        bataille.shoot(new Point(2,2));
        assertTrue(bataille.shoot(new Point(5,5)));
        bataille.shoot(new Point(2,2));
        assertFalse(bataille.shoot(new Point(5,6)));
        bataille.shoot(new Point(2,2));
        assertFalse(bataille.shoot(new Point(7,7)));
    }

    @Test
    void checkPos() { //vérifie si un bateau peut être ajouté ou non à l'emplacement voulu avec un bateau "fantôme"
        bataille = new Bataille();
        bataille.setUp("XX", "Crossed", "temp");
        bataille.addShip(new Croiseur(new Point(1,1), 0)); //croiseur taille 4 en largeur position 1,1
        bataille.addShip(new SousMarin(new Point(5,4), 1)); //sousmarin taille 2 en hauteur position 5,4

        Ship test = new Croiseur(new Point (2,0), 1);
        Ship test2 = new SousMarin(new Point (0,2), 0);

        assertFalse(bataille.checkPos(test, 1));
        assertTrue(bataille.checkPos(test2, 1));
    }
}