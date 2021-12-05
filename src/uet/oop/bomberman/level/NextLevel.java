package uet.oop.bomberman.level;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import static uet.oop.bomberman.entities.Portal.isEndGame;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.Portal.onPortal;
import static uet.oop.bomberman.graphics.Sound.level_complete;

public class NextLevel {

    public static void NewLevel() {
        onPortal = false;
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
                g_mediaPlayer.stop();
                g_mediaPlayer = new MediaPlayer(level_complete);
                g_mediaPlayer.play();
                g_mediaPlayer.setOnEndOfMedia(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
                root.getChildren().removeAll(bg, pa);
                root.getChildren().add(imgView);
                root.getChildren().addAll(pane);
                isEndGame = false;
                break;
        }
    }
}