package Actors;

import Components.PlayerInputComponent;
import Components.SpriteComponent;
import Util.Position2D;

import java.awt.*;
import java.io.IOException;

public class Player extends AbstractActor {

    // TODO:
    private int health;
    private final int speed = 110;
    private final SpriteComponent spriteComponent = new SpriteComponent("./data/img/player.png");
    private final PlayerInputComponent playerInputComponent = PlayerInputComponent.getInstance();

    public Player(Position2D<Float> position, float szX, float szY) throws IOException {
        super(position, szX, szY);
        this.health = 100;
    }

    @Override
    public void update(float deltaT, Graphics2D g) {
        // TODO: or delete
        spriteComponent.draw(g, this.getAABB());
        //check pressed key and update position of player
        if (playerInputComponent.isUpPressed()) {
            this.getPos().y -= speed * deltaT;
        }
        if (playerInputComponent.isDownPressed()) {
            this.getPos().y += speed * deltaT;
        }
        if (playerInputComponent.isLeftPressed()) {
            this.getPos().x -= speed * deltaT;
        }
        if (playerInputComponent.isRightPressed()) {
            this.getPos().x += speed * deltaT;
        }
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
