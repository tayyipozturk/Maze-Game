package Actors;

import Components.*;
import Util.AABB;
import Util.Position2D;

import java.awt.*;
import java.util.ArrayList;

// Meta Actor Class
// Everything in the game is an actor
public abstract class AbstractActor extends AABB {
    // TODO:
    private final PlayerInputComponent playerInputComponent = PlayerInputComponent.getInstance();
    private ArrayList<IRealTimeComponent> realTimeComponents;
    private ArrayList<IDrawable> drawableComponents;
    private CollisionComponent collisionComponent;
    private static ArrayList<AbstractActor> allActors = new ArrayList<>();
    private static ArrayList<Enemy> enemies = new ArrayList<>();

    private int health;
    private int damage;
    private int speed;
    private boolean isAlive;

    public AbstractActor(Position2D<Float> position, float szX, float szY) {
        super(position, szX, szY);
        this.realTimeComponents = new ArrayList<>();
        this.drawableComponents = new ArrayList<>();
        this.collisionComponent = new CollisionComponent();
        damage = 10;
        allActors.add(this);
    }

    public void update(float deltaT, Graphics2D g) {
        // TODO:
        for (IRealTimeComponent component : realTimeComponents) {
            component.update(deltaT);
        }
        for (IDrawable component : drawableComponents) {
            component.draw(g, this.getAABB());
        }
    }

    public abstract boolean isDead();

    public PlayerInputComponent getPlayerInputComponent() {
        return playerInputComponent;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            isAlive = false;
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    @Override
    public Position2D<Float> getPos() {
        return super.getPos();
    }

    @Override
    public float getSizeX() {
        return super.getSizeX();
    }

    @Override
    public float getSizeY() {
        return super.getSizeY();
    }


    public AABB getAABB() {
        return this;
    }

    public void addDrawableComponent(SpriteComponent spriteComponent) {
        drawableComponents.add(spriteComponent);
    }

    public ArrayList<IDrawable> getDrawableComponents() {
        return drawableComponents;
    }

    public void addRealTimeComponent(IRealTimeComponent component) {
        realTimeComponents.add(component);
    }

    public ArrayList<IRealTimeComponent> getRealTimeComponents() {
        return realTimeComponents;
    }

    public void addCollisionComponent(CollisionComponent collisionComponent) {
        this.collisionComponent = collisionComponent;
    }

    public CollisionComponent getCollisionComponent() {
        return collisionComponent;
    }

    public static ArrayList<AbstractActor> getAllActors() {
        return allActors;
    }

    public static void addActor(AbstractActor actor) {
        allActors.add(actor);
    }

    public static void removeActor(AbstractActor actor) {
        allActors.remove(actor);
    }

    public static ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public static void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public static void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

}
