package Actors;

import Components.SpriteComponent;
import Util.Position2D;

import java.awt.*;
import java.io.IOException;

public class Enemy extends AbstractActor {
    // TODO:
    private int health;
    private final int speed = 120;
    private final SpriteComponent spriteComponent = new SpriteComponent("./data/img/enemy.png");

    public Enemy(Position2D<Float> position, float szX, float szY) throws IOException {
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
        spriteComponent.draw(g, this.getAABB());


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

    public void setHealth(int health) {
        this.health = health;
    }
}
