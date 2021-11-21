package uet.oop.bomberman.entities.Bomber;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.position;

public class Bomber extends Bomberman {

    public Bomber(int x, int y, int speed, Image img) {
        super( x, y, speed, img);
        position[x][y] = 1;
    }


    @Override
    public void update() {

    }

    @Override
    public void move() {

    }

    public boolean canMoveDR(int x, int y) {
        if (position[x + this.getX()  / Sprite.SCALED_SIZE][y + this.getY()/ Sprite.SCALED_SIZE] == 0) {
            return true;
        }
        return false;
    }

    public boolean canMoveUL(int x, int y) {
        if (position[(x + this.getX())  / Sprite.SCALED_SIZE][(y + this.getY())/ Sprite.SCALED_SIZE] == 0) {
            return true;
        }
        return false;
    }


}
