package uet.oop.bomberman.entities.Item;

import javafx.scene.image.Image;

import static uet.oop.bomberman.BombermanGame.*;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class SpeedItem extends Item {

    public SpeedItem() {

    }

    public SpeedItem(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public SpeedItem(boolean getItem) {
        super(getItem);
    }

    @Override
    public void update() {
        for (Entity entity : block)
            if (entity instanceof SpeedItem && !this.isGetItem())
                if (destroyObjList[entity.getX() / 32][entity.getY() / 32] == 4)
                    entity.setImg(Sprite.powerup_speed.getFxImage());

        if (!this.getItem)
            if (bomber.getX() == this.x && bomber.getY() == this.y) {
                this.setImg(Sprite.grass.getFxImage());
                this.getItem = true;
                speed = 2;
            }
    }
}