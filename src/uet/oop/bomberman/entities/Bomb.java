package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Enemies.Enemy;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;

import static uet.oop.bomberman.BombermanGame.*;

public class Bomb extends Entity{

    private static long bombTime;
    private static long bombTempTime;
    private static int bombRadius;

    public Bomb(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public Bomb() {

    }

    public void bombTick(){
        if (System.currentTimeMillis() - bombTime < 20000) {
            if (System.currentTimeMillis() - bombTempTime > 1000) {
                bombExplode();
                bombTempTime += 100;
            }
        } else {
            bombTime = System.currentTimeMillis();
            bombTempTime = bombTime;
        }
    }

    public void bombExplode() {
        for(Entity entity : stillObjects){
            if(entity instanceof Brick){
                if(getX() + Sprite.SCALED_SIZE == entity.getX() && getY()  == entity.getY()){
                    stillObjects.remove(entity);
                    Entity object = new Grass(entity.getX() / Sprite.SCALED_SIZE,
                            entity.getY()/Sprite.SCALED_SIZE, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    position[entity.getX() / Sprite.SCALED_SIZE][entity.getY()/Sprite.SCALED_SIZE] = 0;
                }
                if(getX() == entity.getX() && getY() + Sprite.SCALED_SIZE == entity.getY()){
                    stillObjects.remove(entity);
                    Entity object = new Grass(entity.getX() / Sprite.SCALED_SIZE,
                            entity.getY()/Sprite.SCALED_SIZE, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    position[entity.getX() / Sprite.SCALED_SIZE][entity.getY()/Sprite.SCALED_SIZE] = 0;
                }
                if(getX() - Sprite.SCALED_SIZE == entity.getX() && getY() == entity.getY()){
                    stillObjects.remove(entity);
                    Entity object = new Grass(entity.getX() / Sprite.SCALED_SIZE,
                            entity.getY()/Sprite.SCALED_SIZE, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    position[entity.getX() / Sprite.SCALED_SIZE][entity.getY()/Sprite.SCALED_SIZE] = 0;
                }
                if(getX()  == entity.getX() && getY() - Sprite.SCALED_SIZE == entity.getY()){
                    stillObjects.remove(entity);
                    Entity object = new Grass(entity.getX() / Sprite.SCALED_SIZE,
                            entity.getY()/Sprite.SCALED_SIZE, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    position[entity.getX() / Sprite.SCALED_SIZE][entity.getY()/Sprite.SCALED_SIZE] = 0;
                }
            }
        }
        for(Entity entity : entities){
            if(entity instanceof Enemy){
                int x = Math.round(entity.getX() / 32);
                int y = Math.round(entity.getY() / 32);
                int this_x = Math.round(getX() / 32);
                int this_y = Math.round(getY() / 32);
                if(this_x + Sprite.SCALED_SIZE == x && this_y == y){
                    stillObjects.remove(entity);
                }
                if(this_x == x && this_y + Sprite.SCALED_SIZE == y){
                    stillObjects.remove(entity);
                }
                if(this_x - Sprite.SCALED_SIZE == x && this_y == y){
                    stillObjects.remove(entity);
                }
                if(this_x == x && this_y - Sprite.SCALED_SIZE == y){
                    stillObjects.remove(entity);
                }
            }
        }
        entities.remove(this);
        bombBank++;
    }

    public static void placeBomb(int x, int y){
        if(bombBank>0){
            x = Math.round(x / Sprite.SCALED_SIZE);
            y = Math.round(y / Sprite.SCALED_SIZE);
            Bomb bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
            bombTime = System.currentTimeMillis();
            bombTempTime = bombTime;
            entities.add(bomb);
            bombBank--;
        }
    }

    @Override
    public void update() {
        bombTick();
    }

    public int getBombRadius() {
        return bombRadius;
    }

    public void setBombRadius(int bombRadius) {
        this.bombRadius = bombRadius;
    }
}
