package uet.oop.bomberman.entities.Item;


import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.newStillObjects;

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

    public void makeGrass(){
        Entity new_grass = new Grass(x/Sprite.SCALED_SIZE,y/Sprite.SCALED_SIZE, Sprite.grass.getFxImage());
        newStillObjects.add(new_grass);
        setLife(0);
    }

    @Override
    public void update() {

    }
}