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

public class GameOverMenu extends Parent {
    public GameOverMenu() {
        VBox menu = new VBox(15);

        menu.setTranslateX(300);
        menu.setTranslateY(200);

        MenuButton PlayBt = new MenuButton("PlayAgain");
        PlayBt.setOnMouseClicked(event -> {
            _level = 1;
            NewLevel();
            root.getChildren().removeAll(p, iV);
            root.getChildren().add(bg);
            root.getChildren().add(pa);
        });

        MenuButton ExitBt = new MenuButton("Exit");
        ExitBt.setOnMouseClicked(event -> {
            System.exit(0);
        });

        menu.getChildren().addAll(PlayBt, ExitBt);

        getChildren().addAll(menu);
    }

}
