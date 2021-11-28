package uet.oop.bomberman.entities.Enemies;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Enemies.AIMove.AI;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import javax.xml.bind.annotation.XmlType;

import static uet.oop.bomberman.BombermanGame.*;

public abstract class Enemy extends Entity {

    protected int speed;
    protected int direction;
    protected int step;

    protected AI aI;

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas.
    public Enemy(int xUnit, int yUnit, int speed, Image img) {
        super(xUnit, yUnit, img);
        this.speed = speed;
        this.step = 1;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }
    public void update() {
        if(getState() == 0) {
            calculateMove();
            chooseSprite();
        } else {
            dieHandle();
        }
    }
    public void calculateMove() {
        int cX = 0;
        int cY = 0;
        if (step <= 0) {
            direction = aI.calculateDirection();
            this.step = 1;
        }
        if (direction == 0) {
            cX++;
            if (canMoveDR(cX, cY)) {
                move(cX * speed, cY * speed);
            } else {
                this.step = 0;
            }
        } else if (direction == 1) {
            cX--;
            if (canMoveUL(cX, cY)) {
                move(cX * speed, cY * speed);
            } else {
                this.step = 0;
            }
        } else if (direction == 2) {
            cY++;
            if (canMoveDR(cX, cY)) {
                move(cX * speed, cY * speed);
            } else {
                this.step = 0;
            }
        } else {
            cY--;
            if (canMoveUL(cX, cY)) {
                move(cX * speed, cY * speed);
            } else {
                this.step = 0;
            }
        }
    }

    public boolean canMoveDR(int x, int y) {
         if (position[x + this.getX()  / Sprite.SCALED_SIZE][y + this.getY()/ Sprite.SCALED_SIZE] == 0) {
             return true;
         }
         return false;
    }

    public boolean canMoveUL(int x, int y) {
        if (position[(x + this.getX())  / Sprite.SCALED_SIZE][(y + this.getY())/ Sprite.SCALED_SIZE] == 0) {
            return true;
        }
        return false;
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    protected abstract void chooseSprite();
}


