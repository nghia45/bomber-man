package uet.oop.bomberman.Menu;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.iV;
import static uet.oop.bomberman.level.NextLevel.NewLevel;

public class PauseMenu extends Parent {
    public PauseMenu() {
        VBox menu = new VBox(15);
        menu.setTranslateX(300);
        menu.setTranslateY(200);

        MenuButton PlayBt = new MenuButton("PlayAgain");
        PlayBt.setOnMouseClicked(event -> {
            root.getChildren().removeAll(pp, view, slider);
            _level = 1;
            NewLevel();
            running = true;
        });

        MenuButton ResumeBt = new MenuButton("Resume");
        ResumeBt.setOnMouseClicked(event -> {
            running = true;
            root.getChildren().removeAll(pp, view, slider);
        });
        MenuButton ExitBt = new MenuButton("Exit");
        ExitBt.setOnMouseClicked(event -> {
            System.exit(0);
        });

        menu.getChildren().addAll(PlayBt, ResumeBt,ExitBt);

        getChildren().addAll(menu);
    }
}