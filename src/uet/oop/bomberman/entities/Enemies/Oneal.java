package uet.oop.bomberman.entities.Enemies;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Bomber.Bomber;
import uet.oop.bomberman.entities.Enemies.AIMove.AILow;
import uet.oop.bomberman.entities.Enemies.AIMove.AIMedium;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class Oneal extends Enemy {
    public Oneal (int x, int y,  int speed, Image img) {
        super( x, y, speed, img);
        aI = new AIMedium(this);
        direction = 0;
    }

    @Override
    protected void chooseSprite(){
        Image img;
        switch (direction) {
            case 1:
                img = Sprite.oneal_left1.getFxImage();
                break;
            case 2:
                img = Sprite.oneal_left3.getFxImage();
                break;
            case 3:
                img = Sprite.balloom_right2.getFxImage();
                break;
            default:
                img = Sprite.balloom_right1.getFxImage();
        }
    }
}
