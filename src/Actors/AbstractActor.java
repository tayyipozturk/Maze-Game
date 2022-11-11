package Actors;

import Components.SpriteComponent;
import Util.AABB;
import Util.Position2D;

import java.awt.*;

// Meta Actor Class
// Everything in the game is an actor
public abstract class AbstractActor extends AABB {
    // TODO:
    private SpriteComponent spriteComponent;

    public AbstractActor(Position2D<Float> position, float szX, float szY) {
        super(position, szX, szY);
    }

    public void update(float deltaT, Graphics2D g) {
        // TODO:

    }

    public abstract boolean isDead();

    @Override
    public Position2D<Float> getPos() {
        return super.getPos();
    }

    @Override
    public float getSizeX() {
        return super.getSizeX();
    }

    @Override
    public float getSizeY() {
        return super.getSizeY();
    }


    public AABB getAABB() {
        return this;
    }
}
