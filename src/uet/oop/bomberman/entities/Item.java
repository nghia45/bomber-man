package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public abstract class Item extends Entity {

    private boolean getItem = false;

    public Item(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public Item() {
        super();
    }

    public Item(boolean getItem) {
        this.getItem = getItem;
    }

    public boolean isGetItem() {
        return getItem;
    }

    public void setGetItem(boolean getItem) {
        this.getItem = getItem;
    }

    @Override
    public void update() {

    }
}
