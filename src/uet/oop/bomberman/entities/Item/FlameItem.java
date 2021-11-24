package uet.oop.bomberman.entities.Item;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.bomber;

public class FlameItem extends Item {
    public FlameItem() {

    }

    public FlameItem(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public FlameItem(boolean getItem) {
        super(getItem);
    }

    @Override
    public void update() {
        if (!this.getItem)
            if (bomber.getX() == this.getX() && bomber.getY() == this.getY()) {
                this.setImg(Sprite.grass.getFxImage());
                this.getItem = true;
                bombRadius += 2;
            }
    }
}
