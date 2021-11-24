package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public class Flame extends Entity{

    private String flame_type;

    public Flame() {
    }

    public Flame(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public String getFlame_type() {
        return flame_type;
    }

    public void setFlame_type(String flame_type) {
        this.flame_type = flame_type;
    }

    @Override
    public void update() {

    }
}
