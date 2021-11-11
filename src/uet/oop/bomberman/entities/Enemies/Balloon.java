package uet.oop.bomberman.entities.Enemies;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.entities.Entity;

public class Balloon extends Enemy {

    public Balloon (int x, int y, int speed, int direction, Image img) {
        super( x, y, speed, direction, img);
    }

}
