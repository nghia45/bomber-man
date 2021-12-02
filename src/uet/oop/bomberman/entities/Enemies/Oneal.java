package uet.oop.bomberman.entities.Enemies;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Bomber.Bomber;
import uet.oop.bomberman.entities.Enemies.AIMove.AILow;
import uet.oop.bomberman.entities.Enemies.AIMove.AIMedium;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.*;

public class Oneal extends Enemy {

    protected Random random = new Random();
    protected int speedChange;

    public Oneal (int x, int y,  Image img) {
        super( x, y, img);
        aI = new AIMedium(this);
        direction = 0;
        speedChange = 0;
        speed = 2;
    }

    @Override
    protected void chooseSprite() {
        switch (state) {
            case 0:
                switch (direction) {
                    case 1:
                        img = Sprite.oneal_left1.getFxImage();
                        break;
                    case 2:
                        img = Sprite.oneal_left3.getFxImage();
                        break;
                    case 3:
                        img = Sprite.oneal_right1.getFxImage();
                        break;
                    case 4:
                        img = Sprite.oneal_right3.getFxImage();
                        break;
                }
                break;
            default:
                img = Sprite.oneal_dead.getFxImage();
                break;
        }
    }

    @Override
    public void enemyAbility() {
        speedChange++;
        if (speedChange == 300) {
            speed = random.nextInt(4);
            speedChange = 0;
        }
    }

    @Override
    public void dieHandle() {
        this.setLife(0);
    }
}
