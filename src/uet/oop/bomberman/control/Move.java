package uet.oop.bomberman.control;

import uet.oop.bomberman.entities.Entity;

public class Move {
    public static void move_up(Entity entity, int step){
        entity.setY(entity.getY() - step);
    }
    public static void move_down(Entity entity, int step){
        entity.setY(entity.getY() + step);
    }
    public static void move_left(Entity entity, int step){
        entity.setX(entity.getX() - step);
    }
    public static void move_right(Entity entity, int step){
        entity.setX(entity.getX() + step);
    }
}
