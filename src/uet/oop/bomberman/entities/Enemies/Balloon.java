package uet.oop.bomberman.entities.Enemies;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Enemies.AIMove.AILow;

public class Balloon extends Enemy {

    public Balloon (int x, int y, int speed, Image img) {
        super( x, y, speed, img);
        aI = new AILow();
        direction = 0;
    }

}
