package uet.oop.bomberman.entities.Bomber;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.position;

public class Bomber extends Bomberman {

    protected int direction;

    public Bomber(int x, int y, int speed, Image img) {
        super( x, y, speed, img);
        position[x][y] = 1;
        direction = 0;
    }


    @Override
    public void update() {
        chooseSprite();
    }

    @Override
    protected void chooseSprite() {
        int dir = getDirection();
        switch (dir) {
            case 0:
                img = Sprite.player_right.getFxImage();
                break;
            case 1:
                img = Sprite.player_left.getFxImage();
                break;
            case 2:
                img = Sprite.player_up.getFxImage();
                break;
            case 3:
                img = Sprite.player_down.getFxImage();
                break;

        }
    }

    public boolean canMoveDR(int x, int y) {
        return position[x + this.getX() / Sprite.SCALED_SIZE][y + this.getY() / Sprite.SCALED_SIZE] == 0;
    }

    public boolean canMoveUL(int x, int y) {
        return position[(x + this.getX()) / Sprite.SCALED_SIZE][(y + this.getY()) / Sprite.SCALED_SIZE] == 0;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
