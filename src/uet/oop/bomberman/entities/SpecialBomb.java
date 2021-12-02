package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import uet.oop.bomberman.entities.Bomber.Bomber;
import uet.oop.bomberman.entities.Enemies.Enemy;
import uet.oop.bomberman.entities.Item.BombItem;
import uet.oop.bomberman.entities.Item.FlameItem;
import uet.oop.bomberman.entities.Item.SpeedItem;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.entities;

public class SpecialBomb extends Entity{

    private long bombTime = System.currentTimeMillis();
    private int bombState = 0;
    ArrayList<Flame> flame = new ArrayList<>();

    public SpecialBomb(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public SpecialBomb() {

    }

    public void bombTick(){
        if (bombState < 9 && System.currentTimeMillis() - bombTime > 200) {
            bombState++;
            handleBombAnimation();
            bombTime = System.currentTimeMillis();
            position[this.getX() / Sprite.SCALED_SIZE][this.getY() / Sprite.SCALED_SIZE] = 9;
        }
        if(bombState == 9){
            bombState++;
            handleBombAnimation();
            bombExplode();
            bombTime = System.currentTimeMillis();
        }
        if(bombState > 9 && System.currentTimeMillis() - bombTime > 100){
            bombState++;
            handleBombAnimation();
            bombTime = System.currentTimeMillis();
        }
        if(bombState > 13){
            setLife(0);
            position[this.getX() / Sprite.SCALED_SIZE][this.getY() / Sprite.SCALED_SIZE] = 0;
            stillObjects.removeAll(flame);
            bombBank++;
        }
    }

    public void bombExplode() {
        Media sound = new Media(new File("res/sound/bomb_explosion.wav").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        ArrayList<Entity> new_grass = new ArrayList<>();
        boolean end_top = false, end_down = false, end_left = false, end_right = false;
        for (int i = 1; i <= bombRadius; i++){
            if (!end_right) {
                Iterator<Entity> entitylist = stillObjects.iterator();
                while (entitylist.hasNext()) {
                    Entity entity = entitylist.next();
                    if (getX() + Sprite.SCALED_SIZE * i == entity.getX() && getY() == entity.getY()) {
                        if (entity instanceof Brick || entity instanceof Grass) {
                            if (entity instanceof Brick) {
                                end_right = true;
                                Entity object;
                                switch (position[entity.getX() / Sprite.SCALED_SIZE][entity.getY() / Sprite.SCALED_SIZE]) {
                                    case 4:
                                        object = new SpeedItem(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.powerup_wallpass.getFxImage());
                                        new_grass.add(object);
                                        break;
                                    case 5:
                                        object = new FlameItem(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.powerup_flames.getFxImage());
                                        new_grass.add(object);
                                        break;
                                    case 6:
                                        object = new BombItem(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.powerup_bombs.getFxImage());
                                        new_grass.add(object);
                                        break;
                                    default:
                                        object = new Grass(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.grass.getFxImage());
                                        new_grass.add(object);
                                }
                            }
                            Flame new_flame = new Flame(entity.getX() / Sprite.SCALED_SIZE,
                                    entity.getY() / Sprite.SCALED_SIZE, Sprite.explosion_horizontal.getFxImage());
                            flame.add(new_flame);
                            new_flame.setFlame_type("RIGHT");
                            if (i == bombRadius || end_right) {
                                new_flame.setImg(Sprite.explosion_horizontal_right_last.getFxImage());
                                new_flame.setFlame_type("RIGHT_LAST");
                            }
                        } else if (entity instanceof Wall) {
                            end_right = true;
                        }
                    }
                }
            }
            if (!end_down) {
                Iterator<Entity> entitylist = stillObjects.iterator();
                while (entitylist.hasNext()) {
                    Entity entity = entitylist.next();
                    if (getX() == entity.getX() && getY() + Sprite.SCALED_SIZE * i == entity.getY()) {
                        if (entity instanceof Brick || entity instanceof Grass) {
                            if(entity instanceof Brick){
                                end_down = true;
                                entitylist.remove();
                                Entity object;
                                switch (position[entity.getX() / Sprite.SCALED_SIZE][entity.getY() / Sprite.SCALED_SIZE]) {
                                    case 4:
                                        object = new SpeedItem(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.powerup_wallpass.getFxImage());
                                        new_grass.add(object);
                                        break;
                                    case 5:
                                        object = new FlameItem(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.powerup_flames.getFxImage());
                                        new_grass.add(object);
                                        break;
                                    case 6:
                                        object = new BombItem(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.powerup_bombs.getFxImage());
                                        new_grass.add(object);
                                        break;
                                    default:
                                        object = new Grass(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.grass.getFxImage());
                                        new_grass.add(object);
                                }
                            }
                            Flame new_flame = new Flame(entity.getX() / Sprite.SCALED_SIZE,
                                    entity.getY() / Sprite.SCALED_SIZE, Sprite.explosion_vertical.getFxImage());
                            flame.add(new_flame);
                            new_flame.setFlame_type("DOWN");
                            if (i == bombRadius || end_down) {
                                new_flame.setImg(Sprite.explosion_vertical_down_last.getFxImage());
                                new_flame.setFlame_type("DOWN_LAST");
                            }
                        } else if (entity instanceof Wall) {
                            end_down = true;
                        }
                    }
                }
            }
            if (!end_left) {
                Iterator<Entity> entitylist = stillObjects.iterator();
                while (entitylist.hasNext()) {
                    Entity entity = entitylist.next();
                    if (getX() - Sprite.SCALED_SIZE * i == entity.getX() && getY() == entity.getY()) {
                        if (entity instanceof Brick || entity instanceof Grass) {
                            if(entity instanceof Brick){
                                end_left = true;
                                entitylist.remove();
                                Entity object;
                                switch (position[entity.getX() / Sprite.SCALED_SIZE][entity.getY() / Sprite.SCALED_SIZE]) {
                                    case 4:
                                        object = new SpeedItem(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.powerup_wallpass.getFxImage());
                                        new_grass.add(object);
                                        break;
                                    case 5:
                                        object = new FlameItem(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.powerup_flames.getFxImage());
                                        new_grass.add(object);
                                        break;
                                    case 6:
                                        object = new BombItem(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.powerup_bombs.getFxImage());
                                        new_grass.add(object);
                                        break;
                                    default:
                                        object = new Grass(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.grass.getFxImage());
                                        new_grass.add(object);
                                }
                            }
                            Flame new_flame = new Flame(entity.getX() / Sprite.SCALED_SIZE,
                                    entity.getY() / Sprite.SCALED_SIZE, Sprite.explosion_horizontal.getFxImage());
                            flame.add(new_flame);
                            new_flame.setFlame_type("LEFT");
                            if (i == bombRadius || end_left) {
                                new_flame.setImg(Sprite.explosion_horizontal_left_last.getFxImage());
                                new_flame.setFlame_type("LEFT_LAST");
                            }
                        } else if (entity instanceof Wall) {
                            end_left = true;
                        }
                    }
                }
            }
            if (!end_top) {
                Iterator<Entity> entitylist = stillObjects.iterator();
                while (entitylist.hasNext()) {
                    Entity entity = entitylist.next();
                    if (getX() == entity.getX() && getY() - Sprite.SCALED_SIZE * i == entity.getY()) {
                        if (entity instanceof Brick || entity instanceof Grass) {
                            if(entity instanceof Brick){
                                end_top = true;
                                entitylist.remove();
                                Entity object;
                                switch (position[entity.getX() / Sprite.SCALED_SIZE][entity.getY() / Sprite.SCALED_SIZE]) {
                                    case 4:
                                        object = new SpeedItem(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.powerup_wallpass.getFxImage());
                                        new_grass.add(object);
                                        break;
                                    case 5:
                                        object = new FlameItem(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.powerup_flames.getFxImage());
                                        new_grass.add(object);
                                        break;
                                    case 6:
                                        object = new BombItem(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.powerup_bombs.getFxImage());
                                        new_grass.add(object);
                                        break;
                                    default:
                                        object = new Grass(entity.getX() / Sprite.SCALED_SIZE,
                                                entity.getY() / Sprite.SCALED_SIZE, Sprite.grass.getFxImage());
                                        new_grass.add(object);
                                }
                            }
                            Flame new_flame = new Flame(entity.getX() / Sprite.SCALED_SIZE,
                                    entity.getY() / Sprite.SCALED_SIZE, Sprite.explosion_vertical.getFxImage());
                            flame.add(new_flame);
                            new_flame.setFlame_type("TOP");
                            if (i == bombRadius || end_top) {
                                new_flame.setImg(Sprite.explosion_vertical_top_last.getFxImage());
                                new_flame.setFlame_type("TOP_LAST");
                            }
                        } else if (entity instanceof Wall) {
                            end_top = true;
                        }
                    }
                }
            }
        }
        for (Entity grass : new_grass) {
            position[grass.getX() / Sprite.SCALED_SIZE][grass.getY() / Sprite.SCALED_SIZE] = 0;
            stillObjects.add(grass);
        }
        stillObjects.addAll(flame);
        position[getX()/Sprite.SCALED_SIZE][getY()/Sprite.SCALED_SIZE] = 0;
        for (Flame _flame : flame) {
            for (Entity _enemy : entities) {
                if (_enemy instanceof Bomber) {
                    if (_flame.getX() - Sprite.SCALED_SIZE / 2 <= _enemy.getX() &&
                            _flame.getX() + Sprite.SCALED_SIZE / 2 >= _enemy.getX()) {
                        if (_flame.getY() - Sprite.SCALED_SIZE / 2 <= _enemy.getY()
                                && _flame.getY() + Sprite.SCALED_SIZE / 2 >= _enemy.getY()) {
                            _enemy.setState(1);
                        }
                    }
                }
            }
        }
    }

    public void handleBombAnimation(){
        switch (bombState){
            case 1: case 4: case 7 :
                this.setImg(Sprite.bomb_1.getFxImage());
                break;
            case 2: case 5: case 8:
                this.setImg(Sprite.bomb_2.getFxImage());
                break;
            case 3: case 6: case 9:
                this.setImg(Sprite.bomb.getFxImage());
                break;
            case 10:
                this.setImg(Sprite.bomb_exploded.getFxImage());
                for (Flame _flame : flame){
                    switch (_flame.getFlame_type()){
                        case "DOWN": case "TOP":
                            _flame.setImg(Sprite.explosion_vertical.getFxImage());
                            break;
                        case "RIGHT": case "LEFT":
                            _flame.setImg(Sprite.explosion_horizontal.getFxImage());
                            break;
                        case "DOWN_LAST":
                            _flame.setImg(Sprite.explosion_vertical_down_last.getFxImage());
                            break;
                        case "TOP_LAST":
                            _flame.setImg(Sprite.explosion_vertical_top_last.getFxImage());
                            break;
                        case "RIGHT_LAST":
                            _flame.setImg(Sprite.explosion_horizontal_right_last.getFxImage());
                            break;
                        case "LEFT_LAST":
                            _flame.setImg(Sprite.explosion_horizontal_left_last.getFxImage());
                            break;
                    }
                }
                break;
            case 11:
                this.setImg(Sprite.bomb_exploded1.getFxImage());
                for (Flame _flame : flame){
                    switch (_flame.getFlame_type()){
                        case "DOWN": case "TOP":
                            _flame.setImg(Sprite.explosion_vertical1.getFxImage());
                            break;
                        case "RIGHT": case "LEFT":
                            _flame.setImg(Sprite.explosion_horizontal1.getFxImage());
                            break;
                        case "DOWN_LAST":
                            _flame.setImg(Sprite.explosion_vertical_down_last1.getFxImage());
                            break;
                        case "TOP_LAST":
                            _flame.setImg(Sprite.explosion_vertical_top_last1.getFxImage());
                            break;
                        case "RIGHT_LAST":
                            _flame.setImg(Sprite.explosion_horizontal_right_last1.getFxImage());
                            break;
                        case "LEFT_LAST":
                            _flame.setImg(Sprite.explosion_horizontal_left_last1.getFxImage());
                            break;
                    }
                }
                break;
            case 12:
                this.setImg(Sprite.bomb_exploded2.getFxImage());
                for (Flame _flame : flame){
                    switch (_flame.getFlame_type()){
                        case "DOWN": case "TOP":
                            _flame.setImg(Sprite.explosion_vertical2.getFxImage());
                            break;
                        case "RIGHT": case "LEFT":
                            _flame.setImg(Sprite.explosion_horizontal2.getFxImage());
                            break;
                        case "DOWN_LAST":
                            _flame.setImg(Sprite.explosion_vertical_down_last2.getFxImage());
                            break;
                        case "TOP_LAST":
                            _flame.setImg(Sprite.explosion_vertical_top_last2.getFxImage());
                            break;
                        case "RIGHT_LAST":
                            _flame.setImg(Sprite.explosion_horizontal_right_last2.getFxImage());
                            break;
                        case "LEFT_LAST":
                            _flame.setImg(Sprite.explosion_horizontal_left_last2.getFxImage());
                            break;
                    }
                }
                break;
            default:
        }
    }

    @Override
    public void update() {
        bombTick();
    }
}
