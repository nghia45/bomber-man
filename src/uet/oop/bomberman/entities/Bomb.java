package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Enemies.Enemy;
import uet.oop.bomberman.graphics.Sprite;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import static uet.oop.bomberman.BombermanGame.*;

public class Bomb extends Entity{

    private static long bombTime;
    private static long bombTempTime;
    private static int bombState = 0;

    public Bomb(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public Bomb() {

    }

    public void bombTick(){
        if (System.currentTimeMillis() - bombTime < 20000) {
            if (System.currentTimeMillis() - bombTempTime > 3000) {
                bombState = 3;
                bombExplodeHandle();
                bombTempTime += 100;
            }
        } else {
            setImg(Sprite.bomb_2.getFxImage());
            bombState++;
            bombTime = System.currentTimeMillis();
            bombTempTime = bombTime;
        }
    }

    public void bombExplodeHandle() {
        if (System.currentTimeMillis() - bombTime < 40000) {
            if (System.currentTimeMillis() - bombTempTime > 3000) {
                setImg(Sprite.bomb_exploded.getFxImage());
                Media sound = new Media(new File("res/sound/bomb_explosion.wav").toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
                bombExplode();
            }
        }
    }

    public void bombExplode() {
        Iterator<Entity> entitylist = stillObjects.iterator();
        ArrayList<Entity> new_grass = new ArrayList<>();
        ArrayList<Entity> new_flame = new ArrayList<>();
        this.setImg(Sprite.bomb_exploded.getFxImage());
        bombTempTime += 1000;
        while (entitylist.hasNext()) {
            Entity entity = entitylist.next();
            if (entity instanceof Brick) {
                for(int i = 1; i<=bombRadius; i++) {
                    if (getX() + Sprite.SCALED_SIZE*i == entity.getX() && getY() == entity.getY()) {
                        entitylist.remove();
                        Entity object = new Grass(entity.getX() / Sprite.SCALED_SIZE,
                                entity.getY() / Sprite.SCALED_SIZE, Sprite.grass.getFxImage());
                        new_grass.add(object);
                        Entity flame = new Flame(entity.getX() / Sprite.SCALED_SIZE,
                                entity.getY() / Sprite.SCALED_SIZE, Sprite.explosion_horizontal_right_last.getFxImage());
                        break;
                    }
                }
                for(int i = 1; i<=bombRadius; i++) {
                    if (getX() == entity.getX() && getY() + Sprite.SCALED_SIZE*i == entity.getY()) {
                        entitylist.remove();
                        Entity object = new Grass(entity.getX() / Sprite.SCALED_SIZE,
                                entity.getY() / Sprite.SCALED_SIZE, Sprite.grass.getFxImage());
                        new_grass.add(object);
                    }
                    break;
                }
                for(int i = 1; i<=bombRadius; i++) {
                    if (getX() - Sprite.SCALED_SIZE*i == entity.getX() && getY() == entity.getY()) {
                        entitylist.remove();
                        Entity object = new Grass(entity.getX() / Sprite.SCALED_SIZE,
                                entity.getY() / Sprite.SCALED_SIZE, Sprite.grass.getFxImage());
                        new_grass.add(object);
                    }
                    break;
                }
                for(int i = 1; i<=bombRadius; i++) {
                    if (getX() == entity.getX() && getY() - Sprite.SCALED_SIZE*i == entity.getY()) {
                        entitylist.remove();
                        Entity object = new Grass(entity.getX() / Sprite.SCALED_SIZE,
                                entity.getY() / Sprite.SCALED_SIZE, Sprite.grass.getFxImage());
                        new_grass.add(object);
                    }
                    break;
                }
            }
        }
        for (Entity grass : new_grass) {
            position[grass.getX() / Sprite.SCALED_SIZE][grass.getY() / Sprite.SCALED_SIZE] = 0;
            stillObjects.add(grass);
        }
        setLife(0);
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

    public void handleBombAnimation(){
        switch (bombState){
            case 1:
                this.setImg(Sprite.bomb_1.getFxImage());
                break;
            case 2:
                this.setImg(Sprite.bomb_2.getFxImage());
                break;
            case 3:
                this.setImg(Sprite.bomb_exploded.getFxImage());
                break;
        }
    }

    @Override
    public void update() {
        bombTick();
    }
}
