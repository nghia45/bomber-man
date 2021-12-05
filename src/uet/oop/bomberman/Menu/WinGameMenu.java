package uet.oop.bomberman.Menu;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.graphics.Sound.level_complete;
import static uet.oop.bomberman.level.NextLevel.NewLevel;

public class WinGameMenu extends Parent {
    public WinGameMenu() {
        VBox menu = new VBox(15);

        menu.setTranslateX(300);
        menu.setTranslateY(200);

        MenuButton PlayBt = new MenuButton("PlayAgain");
        PlayBt.setOnMouseClicked(event -> {
            _level = 1;
            NewLevel();
            root.getChildren().removeAll(pane, imgView);
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
