package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;


import static uet.oop.bomberman.BombermanGame.block;
import static uet.oop.bomberman.BombermanGame.destroyObjList;

public class Brick extends Entity {

    public Brick(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        for (Entity entity : block) {
            if (entity instanceof Brick)
                if (destroyObjList[entity.getX() / 32][entity.getY() / 32] == 4) {
                    entity.setImg(Sprite.grass.getFxImage());
                }
        }
    }
}
