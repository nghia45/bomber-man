package uet.oop.bomberman.entities.Bomber;

import uet.oop.bomberman.entities.Entity;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Bomberman extends Entity {
    protected int speed;

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Bomberman( int xUnit, int yUnit, int speed, Image img) {
        super(xUnit, yUnit, img);
        this.speed = speed;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }
    public abstract void update();
    public abstract void move();
}
