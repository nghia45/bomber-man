package uet.oop.bomberman.entities.Bomber;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import uet.oop.bomberman.Menu.GameOverMenu;
import uet.oop.bomberman.entities.Enemies.Enemy;
import uet.oop.bomberman.entities.Entity;
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

    @Override
    public void update() {
        chooseSprite();
        checkEnemy();
        if (bomber.getLife() == 0) {
            entities.clear();
            stillObjects.clear();
            root.getChildren().add(iV);
            root.getChildren().addAll(p);
        }
    }

    public void checkEnemy(){
        for (Entity entity : entities){
            if(entity instanceof Enemy){
                if (getX() - Sprite.SCALED_SIZE <= entity.getX() &&
                        getX() + Sprite.SCALED_SIZE >= entity.getX()) {
                    if (getY() - Sprite.SCALED_SIZE <= entity.getY()
                            && getY() + Sprite.SCALED_SIZE>= entity.getY()) {
                        setLife(0);
                    }
                }
            }
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