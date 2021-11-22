package uet.oop.bomberman.entities.Enemies.AIMove;

import com.sun.media.sound.EmergencySoundbank;
import uet.oop.bomberman.entities.Bomber.Bomber;
import uet.oop.bomberman.entities.Enemies.Enemy;
import uet.oop.bomberman.graphics.Sprite;

import javax.swing.*;

import static uet.oop.bomberman.BombermanGame.*;

public class AIMedium extends AI{
    Enemy enemy;

    public AIMedium(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public int calculateDirection() {
        int choice = random.nextInt(2);
        if (choice == 0) {
            int direction = checkVertical();
            if (direction != -1) {
                return direction;
            } else {
                return checkHorizontal();
            }
        } else {
            int direction = checkHorizontal();
            if (direction != -1) {
                return direction;
            } else {
                return checkVertical();
            }
        }
    }

    private int checkVertical() {
        if (getYBomberPos() < enemy.getY() / Sprite.SCALED_SIZE ) {
                return 3;
        } else if (getYBomberPos() > enemy.getY() / Sprite.SCALED_SIZE) {
                return 2;
        }
        return -1;
    }

    private int checkHorizontal() {
        if (getXBomberPos() < enemy.getX() / Sprite.SCALED_SIZE) {
                return 1;
        } else if (getXBomberPos() > enemy.getX() / Sprite.SCALED_SIZE) {
                return 0;

        }
        return -1;
    }

    public int getXBomberPos() {
        int bX = 1;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 25; j++) {
                if (position[j][i] == 1) {
                    bX = j;
                }
            }
        }
        return bX;
    }

    public int getYBomberPos() {
        int bY = 1;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 25; j++) {
                if (position[j][i] == 1) {
                    bY = i;
                }
            }
        }
        return bY;
    }

}
