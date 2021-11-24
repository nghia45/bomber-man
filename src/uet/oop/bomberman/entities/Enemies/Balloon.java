package uet.oop.bomberman.entities.Enemies;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Enemies.AIMove.AILow;
import uet.oop.bomberman.graphics.Sprite;

public class Balloon extends Enemy {

    public Balloon (int x, int y, int speed, Image img) {
        super( x, y, speed, img);
        aI = new AILow();
        direction = 0;
    }

    @Override
    protected void chooseSprite() {
        switch (direction) {
            case 0:
                img = Sprite.balloom_right3.getFxImage();
                break;
            case 1:
                img = Sprite.balloom_left3.getFxImage();
                break;
            case 2:
                img = Sprite.balloom_right1.getFxImage();
                break;
            case 3:
                img = Sprite.balloom_left1.getFxImage();
                break;

        }
    }

}
