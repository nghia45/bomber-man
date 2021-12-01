package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import uet.oop.bomberman.Control.Move;
import uet.oop.bomberman.Menu.GameMenu;
import uet.oop.bomberman.Menu.GameOverMenu;
import uet.oop.bomberman.entities.Bomber.Bomber;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.Bomber.Bomberman;
import uet.oop.bomberman.entities.Enemies.Balloon;
import uet.oop.bomberman.entities.Enemies.Oneal;
import uet.oop.bomberman.graphics.Sprite;

import uet.oop.bomberman.graphics.Map;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static uet.oop.bomberman.entities.Portal.*;

public class BombermanGame extends Application {

    public static final int WIDTH = 25;
    public static final int HEIGHT = 15;

    public static int _width = 0;
    public static int _height = 0;
    public static int _level = 1;

    private GraphicsContext gc;
    public static Canvas canvas;

    public static List<Entity> entities = new ArrayList<>();
    public static List<Entity> stillObjects = new ArrayList<>();
    public static List<Entity> newBlock = new ArrayList<>();

    public static int bombBank = 1;
    public static int bombRadius = 1;

    public static int[][] position;

    public static Group root;
    public static ImageView imageView;
    public static ImageView iV;
    public static Pane r;
    public static Pane p;
    public static MediaPlayer g_mediaPlayer;
    public static Slider slider;
    private GameMenu gameMenu;
    public static GameOverMenu gameOverMenu;

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

        slider = new Slider(0, 100, 100);

        slider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                g_mediaPlayer.setVolume(slider.getValue() / 100);
            }
        });

        root.getChildren().addAll(canvas, imageView, r, slider);

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
            if(bomber.getState() == 0) {
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
                }
            }
        });
    }

    public void update() {
        if (bomber != null && bomber.getLife() == 0) {
            entities.clear();
            stillObjects.clear();
            root.getChildren().add(iV);
            root.getChildren().addAll(p);
            bomber.setLife(1);
        } else {
            entities.forEach(Entity::update);
            stillObjects.forEach(Entity::update);
            entities.removeIf(entity -> entity.isLife() == 0);
            if(entities.size() == 1) {
                isEndGame = true;
            }
        }
/*        if(!g_mediaPlayer.getStatus().equals(MediaPlayer.Status.READY)){
            g_mediaPlayer.play();
        }*/
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }
}