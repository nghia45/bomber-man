package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import uet.oop.bomberman.Control.Move;
import uet.oop.bomberman.entities.Bomber.Bomber;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.Bomber.Bomberman;
import uet.oop.bomberman.entities.Enemies.Balloon;
import uet.oop.bomberman.entities.Enemies.Oneal;
import uet.oop.bomberman.graphics.Sprite;

import uet.oop.bomberman.graphics.Map;
import uet.oop.bomberman.Menu.GameMenu;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 25;
    public static final int HEIGHT = 15;

    public static int _width = 0;
    public static int _height = 0;
    public static int _level = 1;
    
    public static GraphicsContext gc;
    private Canvas canvas;
    public static  Bomber bomber;
    public static boolean running;

    public static List<Entity> entities = new ArrayList<>();
    public static List<Entity> stillObjects = new ArrayList<>();
    public static final List<Entity> block = new ArrayList<>();

    public static int[][] position;
    public static int[][] destroyObjList;

    public static Group root;
    public static ImageView imageView;
    public static Pane r;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    private GameMenu gameMenu;
    @Override
    public void start(Stage stage) {
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();
        root = new Group();
        gameMenu = new GameMenu();
        r = new Pane();
        r.getChildren().add(gameMenu);
        Image img = new Image("img/menu.png");
        imageView = new ImageView(img);

        root.getChildren().addAll(canvas, imageView, r);

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
                /*case SPACE:
                    Bomb.putBomb();
                    break;*/
            }
        });

    }
    public void update() {
        entities.forEach(Entity::update);
        stillObjects.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }

}
