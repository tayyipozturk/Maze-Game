package Actors;

import Components.SpriteComponent;
import Util.Position2D;

import java.awt.*;
import java.io.IOException;

public class PowerUp extends AbstractActor {
    private boolean isCollected;

    public PowerUp(Position2D<Float> position, float szX, float szY) throws IOException {
        super(position, szX, szY);
        isCollected = false;
        addDrawableComponent(new SpriteComponent("./data/img/scroll.png"));
    }

    @Override
    public void update(float deltaT, Graphics2D g) {
        super.update(deltaT, g);
        if (getCollisionComponent().getCollisionListener().getIsCollidedWithPlayer()) {
            isCollected = true;
            getCollisionComponent().getCollisionListener().setIsCollidedWithPlayer(false);
        }
    }

    @Override
    public boolean isDead() {
        return isCollected;
    }

    @Override
    public void setHealth(int health) {
        System.err.println("ERROR: powerups does not have health.");
    }

    @Override
    public int getHealth() {
        System.err.println("ERROR: powerups does not have health.");
        return -1;
    }

    @Override
    public void setDamage(int damage) {
        System.err.println("ERROR: powerups can not damage other actors.");
    }

    @Override
    public int getDamage() {
        System.err.println("ERROR: powerups can not damage other actors.");
        return -1;
    }

    @Override
    public void setSpeed(int speed) {
        System.err.println("ERROR: powerups can not move.");
    }

    @Override
    public int getSpeed() {
        System.err.println("ERROR: powerups can not move.");
        return -1;
    }
}
