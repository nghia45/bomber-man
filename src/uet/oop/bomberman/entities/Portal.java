package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.level.NextLevel.*;
import static uet.oop.bomberman.BombermanGame.*;

public class Portal extends Entity {

    public static boolean isEndGame = false;

    public Portal(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        if(isEndGame) {
            position[this.getX() / Sprite.SCALED_SIZE][this.getY() / Sprite.SCALED_SIZE ] = 0;
            if (bomber.getX() == this.getX() && bomber.getY() == this.getY()) {
                _level += 1;
                NewLevel();
            }
        }
    }
}