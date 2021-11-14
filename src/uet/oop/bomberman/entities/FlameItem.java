package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

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

    }
}
