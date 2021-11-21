package uet.oop.bomberman.entities.Item;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public abstract class Item extends Entity {

    protected boolean getItem = false;

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
