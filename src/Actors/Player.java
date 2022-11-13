package Actors;

import Components.SpriteComponent;
import Util.Position2D;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends AbstractActor {

    // TODO:
    private ArrayList<Bullet> bullets = new ArrayList<>();

    public Player(Position2D<Float> position, float szX, float szY) throws IOException {
        super(position, szX, szY);
        this.setSpeed(120);
        this.setIsAlive(true);
        addDrawableComponent(new SpriteComponent("./data/img/player.png"));
    }

    @Override
    public void update(float deltaT, Graphics2D g) {
        // TODO: or delete
        //check pressed key and update position of player
        if (getCollisionComponent().getCollisionListener().getIsCollidedWithWall()) {
            getAABB().moveIfCollide(getCollisionComponent().collidedWall);
        }
        if (getCollisionComponent().getCollisionListener().getIsCollidedWithEnemy()) {
            setIsAlive(false);
        }
        if (getPlayerInputComponent().isUpPressed()) {
            this.getPos().y -= getSpeed() * deltaT;
        }
        if (getPlayerInputComponent().isDownPressed()) {
            this.getPos().y += getSpeed() * deltaT;
        }
        if (getPlayerInputComponent().isLeftPressed()) {
            this.getPos().x -= getSpeed() * deltaT;
        }
        if (getPlayerInputComponent().isRightPressed()) {
            this.getPos().x += getSpeed() * deltaT;
        }

        getCollisionComponent().getCollisionListener().setIsCollidedWithWall(false);
        if (getPlayerInputComponent().isFirePressed()) {
            try {
                bullets.add(new Bullet(new Position2D<>(this.getPos().x + 5, this.getCenter().y), 4, 4));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        for (Bullet bullet : bullets) {
            bullet.update(deltaT, g);
        }
        super.update(deltaT, g);

    }

    @Override
    public boolean isDead() {
        // TODO:
        //Players do not have health they immediately die if they collide with an enemy
        return !getIsAlive();
    }

    @Override
    public void setHealth(int health) {
        System.err.println("Player does not have health");
    }

    @Override
    public int getHealth() {
        System.err.println("Player does not have health");
        return -1;
    }

    @Override
    public void setDamage(int damage) {
        System.err.println("ERROR: players can not damage other actors, yet bullets can.");
    }

    @Override
    public int getDamage() {
        System.err.println("ERROR: players can not damage other actors, yet bullets can.");
        return -1;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
