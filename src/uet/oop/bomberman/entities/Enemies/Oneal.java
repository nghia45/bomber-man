package uet.oop.bomberman.entities.Enemies;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Bomber.Bomber;
import uet.oop.bomberman.entities.Enemies.AIMove.AILow;
import uet.oop.bomberman.entities.Enemies.AIMove.AIMedium;
import static uet.oop.bomberman.BombermanGame.*;

public class Oneal extends Enemy {
    public Oneal (int x, int y,  int speed, Image img) {
        super( x, y, speed, img);
        aI = new AIMedium(this);
        direction = 0;
    }
}
