package uet.oop.bomberman.entities.Bomber;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import uet.oop.bomberman.Menu.GameOverMenu;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class Bomber extends Bomberman {

    protected int direction;
    protected int life = 1;
    public Bomber(int x, int y, int speed, Image img) {
        super( x, y, speed, img);
        position[x][y] = 1;
        direction = 0;
    }

    public Bomber() {

    }

    @Override
    public void update() {
        chooseSprite();
        if (bomber.getLife() == 0) {
            entities.clear();
            stillObjects.clear();
            root.getChildren().add(iV);
            root.getChildren().addAll(p);
        }
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

    public int getLife() {
        return life;
    }

    @Override
    public void setLife(int life) {
        this.life = life;
    }
}
