package uet.oop.bomberman.level;

import uet.oop.bomberman.entities.Bomber.Bomber;
import uet.oop.bomberman.entities.Enemies.Balloon;
import uet.oop.bomberman.entities.Enemies.Oneal;
import uet.oop.bomberman.graphics.Map;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.entities;

public class Level3 {
    public Level3() {
        entities.clear();
        stillObjects.clear();
        new Map("res/levels/Level3.txt");
        bomber = new Bomber(23, 13,1, Sprite.player_right.getFxImage());
        entities.add(bomber);
        Balloon balloon1 = new Balloon(6,1, 1, Sprite.balloom_right1.getFxImage());
        Balloon balloon2 = new Balloon(9,4,1, Sprite.balloom_left3.getFxImage());
        Oneal oneal1 = new Oneal(23,5, 2, Sprite.oneal_right1.getFxImage());
        entities.add(balloon1);
        entities.add(balloon2);
        entities.add(oneal1);
    }
}
