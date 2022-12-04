package Actors;

import Components.SpriteComponent;
import Util.Position2D;

import java.awt.*;
import java.io.IOException;

public class Wall extends AbstractActor {

    public Wall(Position2D<Float> position, float szX, float szY) throws IOException {
        super(position, szX, szY);
        addDrawableComponent(new SpriteComponent("./data/img/wall.png"));
    }

    @Override
    public void update(float deltaT, Graphics2D g) {
        super.update(deltaT, g);
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void setHealth(int health) {
        System.err.println("ERROR: walls does not have health.");
    }

    @Override
    public int getHealth() {
        System.err.println("ERROR: walls does not have health.");
        return -1;
    }

    @Override
    public void setDamage(int damage) {
        System.err.println("ERROR: walls can not damage other actors.");
    }

    @Override
    public int getDamage() {
        System.err.println("ERROR: walls can not damage other actors.");
        return -1;
    }

    @Override
    public void setSpeed(int speed) {
        System.err.println("ERROR: walls can not move.");
    }

    @Override
    public int getSpeed() {
        System.err.println("ERROR: walls can not move.");
        return -1;
    }
}
