package Actors;

import Components.SpriteComponent;
import Util.Position2D;

import java.awt.*;
import java.io.IOException;

public class Player extends AbstractActor {

    // TODO:
    private int health;
    private final int speed = 110;
    private final SpriteComponent spriteComponent = new SpriteComponent("./data/img/player.png");

    public Player(Position2D<Float> position, float szX, float szY) throws IOException {
        super(position, szX, szY);
        this.health = 100;
    }

    @Override
    public void update(float deltaT, Graphics2D g) {
        // TODO: or delete
        spriteComponent.draw(g, this.getAABB());
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
