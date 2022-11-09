package Actors;

import Util.Position2D;

import java.awt.*;

public class Enemy extends AbstractActor {
    // TODO:
    private int health;
    private final int speed = 120;
    private final String spritePath = "./data/img/enemy.png";

    public Enemy(Position2D<Float> position, int szX, int szY) {
        super(position, szX, szY);
        this.health = 100;
    }

    @Override
    public boolean isDead() {
        // TODO:
        return health <= 0;
    }

    @Override
    public void update(float deltaT, Graphics2D g) {
        // TODO: or delete


    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    //TODO: Position of the enemy

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public String getSpritePath() {
        return spritePath;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
