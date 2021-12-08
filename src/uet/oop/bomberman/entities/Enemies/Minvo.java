package uet.oop.bomberman.entities.Enemies;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.Enemies.AIMove.AILow;
import uet.oop.bomberman.entities.Enemies.AIMove.AIMedium;
import uet.oop.bomberman.entities.SpecialBomb;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.entities;
import static uet.oop.bomberman.BombermanGame.*;



public class Minvo extends Enemy{
    protected int releaseTime;

    public Minvo (int x, int y, Image img) {
        super( x, y, img);
        aI = new AILow();
        direction = 0;
        life = 1;
        releaseTime = 0;
        speed = 1;
    }

    @Override
    public void enemyAbility() {
        releaseTime++;
        if (releaseTime == 500) {
            int x = this.getX() / Sprite.SCALED_SIZE;
            int y = this.getY() / Sprite.SCALED_SIZE;
            SpecialBomb sBomb = new SpecialBomb(this.getX() / Sprite.SCALED_SIZE,
                    this.getY() / Sprite.SCALED_SIZE, Sprite.bomb.getFxImage());
            entities.add(sBomb);
            releaseTime = 0;
        }
    }

    @Override
    protected void chooseSprite(){
        Image img;
        switch (direction) {
            case 1:
                img = Sprite.minvo_left1.getFxImage();
                break;
            case 2:
                img = Sprite.minvo_left3.getFxImage();
                break;
            case 3:
                img = Sprite.minvo_right2.getFxImage();
                break;
            default:
                img = Sprite.minvo_right1.getFxImage();
        }
    }

    @Override
    public void speedChanging() {

    }
}
