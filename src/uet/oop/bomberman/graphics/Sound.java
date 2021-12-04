package uet.oop.bomberman.graphics;

import javafx.scene.media.Media;

import java.io.File;

public class Sound {
    public static Media menu_sound = new Media(new File("res/sound/title_screen.wav").toURI().toString());
    public static Media level1_sound = new Media(new File("res/sound/bgm_laudaitinhai.wav").toURI().toString());
    public static Media level2_sound = new Media(new File("res/sound/idol.wav").toURI().toString());
    public static Media level3_sound = new Media(new File("res/sound/roll.wav").toURI().toString());
    public static Media bomb_sound = new Media(new File("res/sound/bomb_explosion.wav").toURI().toString());
    public static Media die_sound = new Media(new File("res/sound/just_died.wav").toURI().toString());
    public static Media level_complete = new Media(new File("res/sound/level_complete.wav").toURI().toString());
}
