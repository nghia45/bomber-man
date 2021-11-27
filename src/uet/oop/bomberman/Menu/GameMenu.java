package uet.oop.bomberman.Menu;

import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.level.*;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.level.NextLevel.*;

public class GameMenu extends Parent {
    public GameMenu() {
        VBox menu = new VBox(15);
        //VBox menu1 = new VBox(15);

        menu.setTranslateX(300);
        menu.setTranslateY(200);
        //menu1.setTranslateX(100);
        //menu1.setTranslateY(200);

        MenuButton PlayBt = new MenuButton("Play");
        PlayBt.setOnMouseClicked(event -> {
            _level = 1;
            NewLevel();
            root.getChildren().removeAll(r, imageView);
        });

        MenuButton ExitBt = new MenuButton("Exit");
        ExitBt.setOnMouseClicked(event -> {
            System.exit(0);
        });

        menu.getChildren().addAll(PlayBt,ExitBt);

        getChildren().addAll(menu);
    }

}

