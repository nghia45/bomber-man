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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uet.oop.bomberman.Control.Move;
import uet.oop.bomberman.Menu.GameMenu;
import uet.oop.bomberman.Menu.GameOverMenu;
import uet.oop.bomberman.Menu.PauseMenu;
import uet.oop.bomberman.Menu.WinGameMenu;
import uet.oop.bomberman.entities.Bomber.Bomber;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaPlayer;

import java.awt.*;
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

    public static MediaPlayer g_mediaPlayer;
    public static Slider slider;

    public static GraphicsContext gc;
    public static Canvas canvas;
    public static Canvas cava;

    public static List<Entity> entities = new ArrayList<>();
    public static List<Entity> stillObjects = new ArrayList<>();

    public static int bombBank = 1;
    public static int bombRadius = 1;

    public static int[][] position;

    public static Group root;
    public static ImageView imageView;
    public static ImageView iV;
    public static Pane r;
    public static Pane p;
    public static ImageView imgView;
    public static Pane pane;
    public static Pane pp;
    public static ImageView view;
    public static Pane pa;
    public static Rectangle bg;
    private GameMenu gameMenu;
    private GameOverMenu gameOverMenu;
    private WinGameMenu winGameMenu;
    private PauseMenu pauseMenu;

    private long lastTime;
    public static int timeNumber = 120;
    public static Text level, bomb, time;


    public static  Bomber bomber;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();
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

        slider = new Slider(0, 100, 100);
        slider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                g_mediaPlayer.setVolume(slider.getValue() / 100);
            }
        });
        slider.setLayoutX(340);
        slider.setLayoutY(50);

        level = new Text("Level: 1");
        level.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        level.setFill(Color.BLACK);
        level.setX(416);
        level.setY(20);
        bomb = new Text("Bombs: 1");
        bomb.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        bomb.setFill(Color.BLACK);
        bomb.setX(512);
        bomb.setY(20);
        time = new Text("Times: 120");
        time.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        time.setFill(Color.BLACK);
        time.setX(608);
        time.setY(20);
        bg = new Rectangle(285,25);
        bg.setFill(Color.GRAY);
        bg.setY(2);
        bg.setX(400);
        pa = new Pane();
        pa.getChildren().addAll(level, bomb, time);
        lastTime = System.currentTimeMillis();

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
                    updateMenu();
                }
            }
        };
        timer.start();

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W:
                    Move.move_up(bomber, Sprite.SCALED_SIZE);
                    break;
                case S:
                    Move.move_down(bomber, Sprite.SCALED_SIZE);
                    break;
                case A:
                    Move.move_left(bomber, Sprite.SCALED_SIZE);
                    break;
                case D:
                    Move.move_right(bomber, Sprite.SCALED_SIZE);
                    break;
                case SPACE:
                    if (bombBank > 0) {
                        int x = Math.round(bomber.getX() / Sprite.SCALED_SIZE);
                        int y = Math.round(bomber.getY() / Sprite.SCALED_SIZE);
                        if (position[x][y] != 2 && position[x][y] != 3) {
                            Bomb bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
                            entities.add(bomb);
                            bombBank--;
                        }
                    }
                    break;
                case P:
                    if(running) {
                        running = !running;
                        root.getChildren().add(view);
                        root.getChildren().addAll(pp, slider);
                    } else {
                        running = !running;
                        root.getChildren().removeAll(pp, view, slider);
                    }
                    break;
            }
        });

    }

    public void update() {
        if (bomber != null && bomber.getLife() == 0) {
            entities.clear();
            stillObjects.clear();
            root.getChildren().add(iV);
            root.getChildren().addAll(p);
            root.getChildren().removeAll(bg, pa);
            bomber.setLife(1);
        } else {
            entities.forEach(Entity::update);
            stillObjects.forEach(Entity::update);
            entities.removeIf(entity -> entity.isLife() == 0);
            if(entities.size() == 1) {
                isEndGame = true;
            }
        }
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }

    public void updateMenu() {
        level.setText("Level: " + _level);
        bomb.setText("Bombs: " + bombBank);
        long now = System.currentTimeMillis();
        if (now -  lastTime > 1000) {
            lastTime = System.currentTimeMillis();

            time.setText("Time: " + timeNumber);
            timeNumber--;
            if (timeNumber < 0)
                bomber.setLife(0);
        }

    }
}