package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.Control.Move;
import uet.oop.bomberman.entities.Bomber.Bomber;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.Bomber.Bomberman;
import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.Enemies.Balloon;
import uet.oop.bomberman.entities.Enemies.Oneal;
import uet.oop.bomberman.graphics.Sprite;

import uet.oop.bomberman.graphics.Map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 25;
    public static final int HEIGHT = 15;

    public static int _width = 0;
    public static int _height = 0;
    public static int _level = 1;
    
    private GraphicsContext gc;
    private Canvas canvas;

    public static List<Entity> entities = new ArrayList<>();
    public static List<Entity> stillObjects = new ArrayList<>();

    public static int bombBank = 1;
    public static int bombRadius = 2;

    public static int[][] position;


    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();
        Map level_1 = new Map("res/levels/Level1.txt");

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Bomberman");

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();

        Bomber bomber = new Bomber(23, 13,1, Sprite.player_right.getFxImage());
        entities.add(bomber);
        Balloon balloon1 = new Balloon(6,1, 1, Sprite.balloom_right1.getFxImage());
        Balloon balloon2 = new Balloon(9,4,1, Sprite.balloom_left3.getFxImage());
        Oneal oneal1 = new Oneal(23,5, 2, Sprite.oneal_right1.getFxImage());
        entities.add(balloon1);
        entities.add(balloon2);
        entities.add(oneal1);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    Move.move_up(bomber, Sprite.SCALED_SIZE);
                    break;
                case DOWN:
                    Move.move_down(bomber, Sprite.SCALED_SIZE);
                    break;
                case LEFT:
                    Move.move_left(bomber, Sprite.SCALED_SIZE);
                    break;
                case RIGHT:
                    Move.move_right(bomber, Sprite.SCALED_SIZE);
                    break;
                case SPACE:
                    if(bombBank>0){
                        int x = Math.round(bomber.getX() / Sprite.SCALED_SIZE);
                        int y = Math.round(bomber.getY() / Sprite.SCALED_SIZE);
                        Bomb bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
                        entities.add(bomb);
                        bombBank--;
                    }
                    break;
            }
        });

    }

    public void update() {
        entities.forEach(Entity::update);
        stillObjects.forEach(Entity::update);
        entities.removeIf(entity -> entity.isLife() == 0);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }
}
