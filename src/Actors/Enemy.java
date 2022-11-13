package Actors;

import Components.AbstractPatrolStrategy;
import Components.HorizontalPatrolStrategy;
import Components.SpriteComponent;
import Components.VerticalPatrolStrategy;
import Util.Position2D;

import java.awt.*;
import java.io.IOException;

public class Enemy extends AbstractActor {
    // TODO:
    private String type;
    private AbstractPatrolStrategy patrolStrategy;

    public Enemy(Position2D<Float> position, float szX, float szY, String type) throws IOException {
        super(position, szX, szY);
        this.setHealth(100);
        this.setDamage(100);
        this.setSpeed(120);
        this.setIsAlive(true);
        this.type = type;
        if (type.equals("Horizontal")) {
            patrolStrategy = new HorizontalPatrolStrategy(getSpeed());
        } else if (type.equals("Vertical")) {
            patrolStrategy = new VerticalPatrolStrategy(getSpeed());
        } else {
            patrolStrategy = null;
        }
        addDrawableComponent(new SpriteComponent("./data/img/enemy.png"));
        addEnemy(this);
    }

    @Override
    public boolean isDead() {
        // TODO:
        return !getIsAlive();
    }

    @Override
    public void update(float deltaT, Graphics2D g) {
        // TODO: or delete
        if (getCollisionComponent().getCollisionListener().getIsCollidedWithWall()) {
            getAABB().moveIfCollide(getCollisionComponent().collidedWall);
            if (type.equals("Horizontal") || type.equals("Vertical")) {
                patrolStrategy.changeDirection();
                setSpeed(patrolStrategy.getSpeed());
            }
        }
        if (type.equals("Horizontal")) {
            this.setSpeed(patrolStrategy.getSpeed());
            this.getPos().x += deltaT * getSpeed();
        }
        if (type.equals("Vertical")) {
            this.setSpeed(patrolStrategy.getSpeed());
            this.getPos().y += deltaT * getSpeed();
        }
        getCollisionComponent().getCollisionListener().setIsCollidedWithWall(false);
        super.update(deltaT, g);
    }
    //TODO: Position of the enemy

    public String getType() {
        return type;
    }
}
