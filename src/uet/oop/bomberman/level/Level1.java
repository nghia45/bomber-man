package uet.oop.bomberman.level;

import uet.oop.bomberman.entities.Bomber.Bomber;
import uet.oop.bomberman.entities.Enemies.Balloon;
import uet.oop.bomberman.entities.Enemies.Doll;
import uet.oop.bomberman.entities.Enemies.Minvo;
import uet.oop.bomberman.entities.Enemies.Oneal;
import uet.oop.bomberman.graphics.Map;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.entities.Item.SpeedItem.speedItem;
import static uet.oop.bomberman.BombermanGame.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.awt.*;
import java.io.File;

import static uet.oop.bomberman.graphics.Sound.level1_sound;

public class Level1 {
    public Level1() {
        entities.clear();
        stillObjects.clear();
        new Map("res/levels/Level1.txt");
        g_mediaPlayer = new MediaPlayer(level1_sound);
        g_mediaPlayer.play();
        bombRadius = 1;
        bombBank = 1;
        speedItem = 0;
        bomber = new Bomber(23, 13,1, Sprite.player_right.getFxImage());
        bomber.setLife(1);
        entities.add(bomber);
        Balloon balloon1 = new Balloon(6,1, Sprite.balloom_right1.getFxImage());
        Balloon balloon2 = new Balloon(9,4, Sprite.balloom_left3.getFxImage());
        Oneal oneal1 = new Oneal(23,5,  Sprite.oneal_right1.getFxImage());
        Doll doll1 = new Doll(1, 13,  Sprite.doll_right1.getFxImage());
        Minvo minvo1  = new Minvo(1, 5, Sprite.minvo_right2.getFxImage());
        entities.add(balloon1);
        entities.add(balloon2);
        entities.add(oneal1);
        entities.add(doll1);
        entities.add(minvo1);
    }
}