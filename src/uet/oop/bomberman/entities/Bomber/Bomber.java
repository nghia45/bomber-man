package uet.oop.bomberman.entities.Bomber;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Enemies.Enemy;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.entities;
import static uet.oop.bomberman.BombermanGame.position;

public class Bomber extends Bomberman {

    public Bomber(int x, int y, int speed, Image img) {
        super( x, y, speed, img);
        position[x][y] = 1;
    }


    @Override
    public void update() {
        checkEnemy();
    }

    @Override
    public void move() {

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

    public void updatePos(){
        int x = getX() / Sprite.SCALED_SIZE;
        int y = getY() / Sprite.SCALED_SIZE;
        x = Math.round(x);
        y = Math.round(y);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 25; j++) {
                if (position[j][i] == 1) {
                    position[j][i] = 0;
                }
            }
        }
        position[x][y] = 1;
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
