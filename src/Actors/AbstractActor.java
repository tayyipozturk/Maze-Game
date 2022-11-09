package Actors;

import Util.AABB;
import Util.Position2D;

import java.awt.*;

// Meta Actor Class
// Everything in the game is an actor
public abstract class AbstractActor extends AABB {
    // TODO:

    public AbstractActor(Position2D<Float> position, int szX, int szY) {
        super(position, szX, szY);
    }
    
    public void update(float deltaT, Graphics2D g) {
        // TODO:
    }

    public abstract boolean isDead();
}
