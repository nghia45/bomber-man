package uet.oop.bomberman.entities.Enemies;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Enemies.AIMove.AIMedium;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.*;

public class Doll extends Enemy {
    public Doll (int x, int y, Image img) {
        super( x, y, img);
        aI = new AIMedium(this);
        direction = 0;
        life = 1;
        speed = 1;
    }

    @Override
    public void enemyAbility() {

    }

    @Override
    protected void chooseSprite(){
        Image img;
        switch (direction) {
            case 1:
                img = Sprite.doll_left1.getFxImage();
                break;
            case 2:
                img = Sprite.doll_left3.getFxImage();
                break;
            case 3:
                img = Sprite.doll_right2.getFxImage();
                break;
            default:
                img = Sprite.doll_right1.getFxImage();
        }
    }

    @Override
    public void dieAnimationHandle() {
          state++;
          if (state == 9) {
              Balloon balloonX = new Balloon(this.getX()/ Sprite.SCALED_SIZE,
                      this.getY() / Sprite.SCALED_SIZE , Sprite.balloom_right1.getFxImage());
              newEntities.add(balloonX);
          }
          if (state > 9) {
              this.setLife(0);
          }
    }

    @Override
    public void speedChanging() {

    }
}
