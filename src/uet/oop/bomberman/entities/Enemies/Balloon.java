package uet.oop.bomberman.entities.Enemies;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Enemies.AIMove.AILow;
import uet.oop.bomberman.graphics.Sprite;

public class Balloon extends Enemy {

    public Balloon (int x, int y, Image img) {
        super( x, y, img);
        aI = new AILow();
        direction = 0;
        speed = 1;
    }

    @Override
    protected void chooseSprite() {
        switch (state) {
            case 0:
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
                break;
            default:
                img = Sprite.balloom_dead.getFxImage();
                break;
        }
    }

    @Override
    public void enemyAbility() {

    }

    @Override
    public void speedChanging() {

    }

}
