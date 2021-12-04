package uet.oop.bomberman.entities.Bomber;

import uet.oop.bomberman.entities.Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Bomberman extends Entity {
    protected int speed;

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Bomberman(int xUnit, int yUnit, int speed, Image img) {
        super(xUnit, yUnit, img);
        this.speed = speed;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }
    public abstract void update();
    protected abstract void chooseSprite();
}
