package uet.oop.bomberman.Control;

import uet.oop.bomberman.entities.Bomber.Bomber;
import uet.oop.bomberman.entities.Entity;
import static uet.oop.bomberman.BombermanGame.*;
import uet.oop.bomberman.graphics.Sprite;

public class Move {
    public static void move_up(Bomber bomber, int step){
        if (position[bomber.getX() / Sprite.SCALED_SIZE][(bomber.getY() - 1) / Sprite.SCALED_SIZE] == 0) {
            position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 0;
            bomber.setY(bomber.getY() - step);
            position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 1;
        }
    }
    public static void move_down(Bomber bomber, int step){
        if (position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE + 1] == 0) {
            position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 0;
            bomber.setY(bomber.getY() + step);
            position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 1;
        }
    }
    public static void move_left(Bomber bomber, int step){
        if (position[(bomber.getX() - 1 )/ Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] == 0) {
            position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 0;
            bomber.setX(bomber.getX() - step);
            position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 1;
        }
    }
    public static void move_right(Bomber bomber, int step){
        if (position[bomber.getX() / Sprite.SCALED_SIZE + 1][bomber.getY() / Sprite.SCALED_SIZE] == 0) {
            position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 0;
            bomber.setX(bomber.getX() + step);
            position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 1;
        }
    }
}
