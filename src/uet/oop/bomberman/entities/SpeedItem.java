package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

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

    }
}
