package uet.oop.bomberman.entities.Enemies.AIMove;

public class AILow extends AI {

    @Override
    public int calculateDirection() {
        return random.nextInt(4);
    }
}
