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

    public int pixel = 0;


    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas.
    public Enemy(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        this.step = 1;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }
    public void update() {
        if(getState() == 0) {
            enemyAbility();
            calculateMove();
        } else {
            dieAnimationHandle();
            //dieHandle();
        }
        chooseSprite();
    }

    public void dieAnimationHandle(){
        if(state == 1){
            long dieTime = System.currentTimeMillis();
            state ++;
        }
        else if (state < 5 && System.currentTimeMillis() - dieTime > 200) {
            state++;
            dieTime = System.currentTimeMillis();
        }
        if(state == 5){
            this.setLife(0);
        }
    }

    public void calculateMove() {
        int cX = 0;
        int cY = 0;
        if (step <= 0) {
            direction = aI.calculateDirection();
            speedChanging();
            this.step = 1;
        }
        if (direction == 0) {
            cX++;
            if (canMoveDR(cX, cY)) {
                move(cX * speed, cY * speed);
                /*
                pixel++;
                if (pixel >= Sprite.SCALED_SIZE) {
                    position[this.getX() / Sprite.SCALED_SIZE][this.getY() / Sprite.SCALED_SIZE] = 11;
                    position[this.getX() / Sprite.SCALED_SIZE - 1][this.getY() / Sprite.SCALED_SIZE] = 0;
                    pixel = 0;
                }

                 */
            } else {
                this.step = 0;
            }
        } else if (direction == 1) {
            cX--;
            if (canMoveUL(cX, cY)) {
                move(cX * speed, cY * speed);
                /*
                pixel++;
                if (pixel >= Sprite.SCALED_SIZE) {
                    position[this.getX() / Sprite.SCALED_SIZE][this.getY() / Sprite.SCALED_SIZE] = 11;
                    position[this.getX() / Sprite.SCALED_SIZE + 1][this.getY() / Sprite.SCALED_SIZE] = 0;
                    pixel = 0;
                }

                 */
            } else {
                this.step = 0;
            }
        } else if (direction == 2) {
            cY++;
            if (canMoveDR(cX, cY)) {
                move(cX * speed, cY * speed);
                /*
                pixel++;
                if (pixel >= Sprite.SCALED_SIZE) {
                    position[this.getX() / Sprite.SCALED_SIZE][this.getY() / Sprite.SCALED_SIZE] = 11;
                    position[this.getX() / Sprite.SCALED_SIZE][this.getY() / Sprite.SCALED_SIZE - 1] = 0;
                    pixel = 0;
                }
                */
            } else {
                this.step = 0;
            }
        } else {
            cY--;
            if (canMoveUL(cX, cY)) {
                move(cX * speed, cY * speed);
                //pixel++;
                //if (pixel >= Sprite.SCALED_SIZE) {
                   // position[this.getX() / Sprite.SCALED_SIZE][this.getY() / Sprite.SCALED_SIZE] = 11;
                    //position[this.getX() / Sprite.SCALED_SIZE][this.getY() / Sprite.SCALED_SIZE + 1] = 0;
                   // pixel = 0;
                //}
            } else {
                this.step = 0;
            }
        }
    }

    public boolean canMoveDR(int x, int y) {
        if (position[x + this.getX()  / Sprite.SCALED_SIZE][y + this.getY()/ Sprite.SCALED_SIZE] == 0) {
            position[this.getX() / Sprite.SCALED_SIZE][this.getY() / Sprite.SCALED_SIZE] = 0;
            return true;
        }
        return false;
    }

    public boolean canMoveUL(int x, int y) {
        if (position[(x + this.getX())  / Sprite.SCALED_SIZE][(y + this.getY())/ Sprite.SCALED_SIZE] == 0) {
            position[this.getX() / Sprite.SCALED_SIZE][this.getY() / Sprite.SCALED_SIZE] = 0;
            return true;
        }
        return false;
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    protected abstract void chooseSprite();

    public abstract void enemyAbility();

    public abstract void speedChanging();

}


