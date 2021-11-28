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
import uet.oop.bomberman.Menu.GameMenu;
import uet.oop.bomberman.Menu.GameOverMenu;
import uet.oop.bomberman.Menu.PauseMenu;
import uet.oop.bomberman.Menu.WinGameMenu;
import uet.oop.bomberman.entities.Bomber.Bomber;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.Bomber.Bomberman;
import uet.oop.bomberman.entities.Enemies.Balloon;
import uet.oop.bomberman.entities.Enemies.Oneal;
import uet.oop.bomberman.graphics.Sprite;

import uet.oop.bomberman.graphics.Map;

import java.util.ArrayList;
import java.util.List;

import static uet.oop.bomberman.entities.Portal.*;

public class BombermanGame extends Application {

    public static final int WIDTH = 25;
    public static final int HEIGHT = 15;
    public static boolean running = true;
    public static int _width = 0;
    public static int _height = 0;
    public static int _level = 1;

    private GraphicsContext gc;
    public static Canvas canvas;

    public static List<Entity> entities = new ArrayList<>();
    public static List<Entity> stillObjects = new ArrayList<>();

    public static int bombBank = 1;
    public static int bombRadius = 1;

    public static int[][] position;

    public static Group root;
    public static ImageView imageView;
    public static ImageView iV;
    public static ImageView imgView;
    public static Pane r;
    public static Pane p;
    public static Pane pane;
    public static Pane pp;
    private GameMenu gameMenu;
    private GameOverMenu gameOverMenu;
    private WinGameMenu winGameMenu;
    private PauseMenu pauseMenu;

    public static  Bomber bomber;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();
        Map level_1 = new Map("res/levels/Level1.txt");

        // Tao root container
        root = new Group();

        gameMenu = new GameMenu();
        r = new Pane();
        r.getChildren().add(gameMenu);
        Image img = new Image("img/menu.png");
        imageView = new ImageView(img);

        p = new Pane();
        gameOverMenu = new GameOverMenu();
        p.getChildren().add(gameOverMenu);
        Image image = new Image("img/gameover.png");
        iV = new ImageView(image);

        winGameMenu = new WinGameMenu();
        pane = new Pane();
        pane.getChildren().add(winGameMenu);
        Image image1 = new Image("img/win.png");
        imgView = new ImageView(image1);

        pauseMenu = new PauseMenu();
        pp = new Pane();
        pp.getChildren().add(pauseMenu);
        root.getChildren().addAll(canvas, imageView, r);

        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Bomberman");

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(running) {
                    render();
                    update();
                }
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
                case SPACE:
                    if(bombBank>0){
                        int x = Math.round(bomber.getX() / Sprite.SCALED_SIZE);
                        int y = Math.round(bomber.getY() / Sprite.SCALED_SIZE);
                        if(position[x][y] != 2 && position[x][y] != 3) {
                            Bomb bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
                            entities.add(bomb);
                            bombBank--;
                        }
                    }
                    break;
                case P:
                    if(running) {
                        running = !running;
                        root.getChildren().add(pp);
                    } else {
                        running = !running;
                        root.getChildren().remove(pp);
                    }
                    break;
            }
        });

    }

    public void update() {
        entities.forEach(Entity::update);
        stillObjects.forEach(Entity::update);
        entities.removeIf(entity -> entity.isLife() == 0);
        if(entities.size() == 1) {
            isEndGame = true;
        }
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }
}