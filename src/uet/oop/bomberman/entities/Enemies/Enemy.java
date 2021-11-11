package uet.oop.bomberman.entities.Enemies;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.entities.Enemies.AIMove.AI;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Enemy extends Entity {
    protected int speed;
    protected int direction;

    protected AI aI;

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas.
    public Enemy( int xUnit, int yUnit, int speed, int direction, Image img) {
        super(xUnit, yUnit, img);
        this.speed = speed;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }
    public void update() {
        calculateMove();
    }
    public void calculateMove() {
        int cX = 0;
        int cY = 0;
        this.direction = aI.calculateDirection();
        if (direction == 0) {
            cX++;
        } else if (direction == 1) {
            cX--;
        } else if (direction == 2) {
            cY++;
        } else {
            cY--;
        }
        if (canMove(cX, cY)) {
            move(cX * speed, cY * speed);
        }
    }
    public boolean canMove(int x, int y) {
         if (x < 1 && x > 14 && y > 1 && y > 14) {
             return false;
         }
         return true;
    }
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }
}


