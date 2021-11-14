package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public class BombItem extends Item {

    public BombItem() {

    }

    public BombItem(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public BombItem(boolean getItem) {
        super(getItem);
    }

    @Override
    public void update() {

    }
}
