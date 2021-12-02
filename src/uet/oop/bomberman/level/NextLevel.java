package uet.oop.bomberman.level;

import static uet.oop.bomberman.entities.Portal.isEndGame;
import static uet.oop.bomberman.BombermanGame.*;
public class NextLevel {

    public static void NewLevel() {
        switch (_level) {
            case 1:
                new Level1();
                isEndGame = false;
                break;
            case 2:
                new Level2();
                isEndGame = false;
                break;
            case 3:
                new Level3();
                isEndGame = false;
                break;
            case 4:
                entities.clear();
                stillObjects.clear();
                root.getChildren().add(imgView);
                root.getChildren().addAll(pane);
                isEndGame = false;
                break;
        }
    }
}