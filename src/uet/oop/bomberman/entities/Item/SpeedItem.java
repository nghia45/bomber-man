package uet.oop.bomberman.entities.Item;

import javafx.scene.image.Image;


import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.bomber;

public class SpeedItem extends Item {

    public static int speedItem = 0;
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
        if (!this.getItem) {
            if (bomber.getX() == this.getX() && bomber.getY() == this.getY()) {
                this.setImg(Sprite.grass.getFxImage());
                this.getItem = true;
                speedItem = 1;
            }
        } else {
            makeGrass();
        }
    }
}
