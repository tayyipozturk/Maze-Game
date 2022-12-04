package Actors;

import Components.BulletEnemyCollisionHandler;
import Components.PlayerInputComponent;
import Components.SpriteComponent;
import Util.Position2D;

import java.awt.*;
import java.io.IOException;

public class Bullet extends AbstractActor {
    private double createTime;
    private final double maxLifeTime = 0.7;
    private String direction;
    private BulletEnemyCollisionHandler bulletEnemyCollisionHandler;

    public Bullet(Position2D<Float> position, float szX, float szY) throws IOException {
        super(position, szX, szY);
        setIsAlive(true);
        setDamage(30);
        setSpeed(300);
        addDrawableComponent(new SpriteComponent("./data/img/bullet.png"));
        try {
            this.direction = PlayerInputComponent.getInstance().getLastKeyPressed();
        } catch (Exception e) {
            this.direction = "right";
        }
        this.createTime = System.currentTimeMillis();
        this.bulletEnemyCollisionHandler = new BulletEnemyCollisionHandler(this, getEnemies());
    }

    @Override
    public void update(float deltaT, Graphics2D g) {
        if (getIsAlive()) {
            super.update(deltaT, g);
            if (direction.equals("up")) {
                this.getPos().y -= deltaT * 300;
            }
            if (direction.equals("down")) {
                this.getPos().y += deltaT * 300;
            }
            if (direction.equals("left")) {
                this.getPos().x -= deltaT * 300;
            }
            if (direction.equals("right")) {
                this.getPos().x += deltaT * 300;
            }
            if (System.currentTimeMillis() - createTime >= maxLifeTime * 1000) {
                setIsAlive(false);
            }
            bulletEnemyCollisionHandler.update(deltaT);
            boolean isCollided = bulletEnemyCollisionHandler.getIsCollided();
            if (isCollided) {
                setIsAlive(false);
                bulletEnemyCollisionHandler.getCollidedEnemy().takeDamage(getDamage());
            }
        }
    }

    @Override
    public boolean isDead() {
        return !getIsAlive();
    }

    @Override
    public void takeDamage(int damage) {
        System.err.println("ERROR: bullets can not be damaged");
    }

    @Override
    public void setHealth(int health) {
        System.err.println("ERROR: bullets does not have health.");
    }

    @Override
    public int getHealth() {
        System.err.println("ERROR: bullets does not have health.");
        return -1;
    }

    public void attachBulletEnemyCollisionHandler(BulletEnemyCollisionHandler bulletEnemyCollisionHandler) {
        this.bulletEnemyCollisionHandler = bulletEnemyCollisionHandler;
    }
}
