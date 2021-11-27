package uet.oop.bomberman.Control;

import uet.oop.bomberman.entities.Bomber.Bomber;
import uet.oop.bomberman.entities.Entity;
import static uet.oop.bomberman.BombermanGame.*;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.entities.Item.SpeedItem.*;

public class Move {
    public static void move_up(Bomber bomber, int step){
        if(speedItem == 0) {
            switch (position[bomber.getX() / Sprite.SCALED_SIZE][(bomber.getY() - 1) / Sprite.SCALED_SIZE]) {
                case 0:
                case 7:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 0;
                    bomber.setY(bomber.getY() - step);
                    bomber.setDirection(2);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 1;
                    break;
            }
        } else {
            switch (position[bomber.getX() / Sprite.SCALED_SIZE][(bomber.getY() - 1) / Sprite.SCALED_SIZE]) {
                case 0:
                case 7:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 0;
                    bomber.setY(bomber.getY() - step);
                    bomber.setDirection(2);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 1;
                    break;
                case 2:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 2;
                    bomber.setY(bomber.getY() - step);
                    bomber.setDirection(2);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 2;
                    break;
                case 3:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 3;
                    bomber.setY(bomber.getY() - step);
                    bomber.setDirection(2);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 3;
                    break;
            }
        }
    }
    public static void move_down(Bomber bomber, int step){
        if(speedItem == 0) {
            switch (position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE + 1]) {
                case 0:
                case 7:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 0;
                    bomber.setY(bomber.getY() + step);
                    bomber.setDirection(3);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 1;
                    break;
            }
        } else {
            switch (position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE + 1]) {
                case 0:
                case 7:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 0;
                    bomber.setY(bomber.getY() + step);
                    bomber.setDirection(3);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 1;
                    break;
                case 2:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 2;
                    bomber.setY(bomber.getY() + step);
                    bomber.setDirection(3);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 2;
                    break;
                case 3:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 3;
                    bomber.setY(bomber.getY() + step);
                    bomber.setDirection(3);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 3;
                    break;
            }
        }
    }
    public static void move_left(Bomber bomber, int step){
        if(speedItem == 0) {
            switch (position[(bomber.getX() - 1) / Sprite.SCALED_SIZE][(bomber.getY() ) / Sprite.SCALED_SIZE]) {
                case 0:
                case 7:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 0;
                    bomber.setX(bomber.getX() - step);
                    bomber.setDirection(1);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 1;
                    break;
            }
        } else {
            switch (position[(bomber.getX() - 1) / Sprite.SCALED_SIZE][(bomber.getY() ) / Sprite.SCALED_SIZE]) {
                case 0:
                case 7:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 0;
                    bomber.setX(bomber.getX() - step);
                    bomber.setDirection(1);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 1;
                    break;
                case 2:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 2;
                    bomber.setX(bomber.getX() - step);
                    bomber.setDirection(1);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 2;
                    break;
                case 3:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 3;
                    bomber.setX(bomber.getX() - step);
                    bomber.setDirection(1);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 3;
                    break;
            }
        }
    }
    public static void move_right(Bomber bomber, int step){
        if(speedItem == 0) {
            switch (position[bomber.getX() / Sprite.SCALED_SIZE + 1][(bomber.getY() ) / Sprite.SCALED_SIZE]) {
                case 0:
                case 7:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 0;
                    bomber.setX(bomber.getX() + step);
                    bomber.setDirection(0);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 1;
                    break;
            }
        } else {
            switch (position[bomber.getX() / Sprite.SCALED_SIZE + 1][(bomber.getY() ) / Sprite.SCALED_SIZE]) {
                case 0:
                case 7:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 0;
                    bomber.setX(bomber.getX() + step);
                    bomber.setDirection(0);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 1;
                    break;
                case 2:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 2;
                    bomber.setX(bomber.getX() + step);
                    bomber.setDirection(0);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 2;
                    break;
                case 3:
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 3;
                    bomber.setX(bomber.getX() + step);
                    bomber.setDirection(0);
                    position[bomber.getX() / Sprite.SCALED_SIZE][bomber.getY() / Sprite.SCALED_SIZE] = 3;
                    break;
            }
        }
    }
}
