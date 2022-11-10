package Actors;

import Components.SpriteComponent;
import Util.Position2D;

import java.awt.*;
import java.io.IOException;

public class Bullet extends AbstractActor {
    // TODO:
    private Position2D<Float> firstPosition;
    private final int damage = 30;
    private final int speed = 300;
    private double timeAlive;
    private final double life = 0.7;
    private final SpriteComponent spriteComponent = new SpriteComponent("./data/img/bullet.png");

    public Bullet(Position2D<Float> position, float szX, float szY) throws IOException {
        super(position, szX, szY);
        this.firstPosition = position;
        this.timeAlive = 0;
    }

    @Override
    public void update(float deltaT, Graphics2D g) {
        // TODO: or delete
        spriteComponent.draw(g, this.getAABB());
    }

    @Override
    public boolean isDead() {
        //TODO: If bullet collides with a wall or with an enemy, it dies. This is also equivalent to the bullet being out of bounds.
        return false;
    }


}
