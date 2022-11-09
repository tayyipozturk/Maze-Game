package Actors;

import Util.Position2D;

import java.awt.*;

public class PowerUp extends AbstractActor {
    // TODO:
    private final String spritePath = "./data/img/scroll.png";

    public PowerUp(Position2D<Float> position, int szX, int szY) {
        super(position, szX, szY);
    }

    @Override
    public void update(float deltaT, Graphics2D g) {
        // TODO or delete
    }

    @Override
    public boolean isDead() {
        // TODO: If collides with a player, it dies.
        return false;
    }


}
