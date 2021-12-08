package uet.oop.bomberman.level;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import uet.oop.bomberman.entities.Bomber.Bomber;
import uet.oop.bomberman.entities.Enemies.Balloon;
import uet.oop.bomberman.entities.Enemies.Doll;
import uet.oop.bomberman.entities.Enemies.Oneal;
import uet.oop.bomberman.graphics.Map;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.entities;
import static uet.oop.bomberman.entities.Item.SpeedItem.speedItem;

import static uet.oop.bomberman.graphics.Sound.level2_sound;

public class Level2 {
    public Level2() {
        entities.clear();
        stillObjects.clear();
        new Map("res/levels/Level2.txt");
        timeNumber = 120;
        Image image1 = new Image("img/meme1.png");
        view = new ImageView(image1);
        view.setX(250);
        g_mediaPlayer.stop();
        g_mediaPlayer = new MediaPlayer(level2_sound);
        g_mediaPlayer.setVolume(slider.getValue() / 100);
        g_mediaPlayer.play();
        g_mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                g_mediaPlayer.seek(Duration.ZERO);
                g_mediaPlayer.play();
            }
        });
        bombRadius = 1;
        bombBank = 1;
        speedItem = 0;
        bomber = new Bomber(23, 13,1, Sprite.player_right.getFxImage());
        bomber.setLife(1);
        entities.add(bomber);
        Balloon balloon1 = new Balloon(6,1,  Sprite.balloom_right1.getFxImage());
        Balloon balloon2 = new Balloon(9,4, Sprite.balloom_left3.getFxImage());
        Oneal oneal1 = new Oneal(23,5,  Sprite.oneal_right1.getFxImage());
        Doll doll = new Doll(5, 10, Sprite.doll_left1.getFxImage());
        entities.add(doll);
        entities.add(balloon1);
        entities.add(balloon2);
        entities.add(oneal1);
    }
}