package Actors;

import Components.SpriteComponent;
import Util.AABB;
import Util.Position2D;

import java.awt.*;

// Meta Actor Class
// Everything in the game is an actor
public abstract class AbstractActor extends AABB {
    // TODO:

    private Position2D<Float> position;
    private float szX;
    private float szY;
    private SpriteComponent spriteComponent;

    public AbstractActor(Position2D<Float> position, float szX, float szY) {
        super(position, szX, szY);
    }

    public void update(float deltaT, Graphics2D g) {
        // TODO:

    }

    public abstract boolean isDead();

    public Position2D<Float> getPosition() {
        return position;
    }

    public AABB getAABB() {
        return this;
    }
}
