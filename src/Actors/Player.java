package Actors;

import Util.Position2D;

import java.awt.*;

public class Player extends AbstractActor {

    // TODO:
    private int health;
    private final int speed = 110;

    public Player(Position2D<Float> position, int szX, int szY) {
        super(position, szX, szY);
        this.health = 100;
    }

    @Override
    public void update(float deltaT, Graphics2D g) {
        // TODO: or delete
    }

    @Override
    public boolean isDead() {
        // TODO:
        //Players do not have health they immediately die if they collide with an enemy
        return health <= 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

}
