package Components;

import Actors.*;
import Util.AABB;
import Util.Position2D;

import java.util.ArrayList;

public class CollisionComponent implements IRealTimeComponent {
    // TODO:
    private CollisionListener collisionListener;
    private AbstractActor actor;

    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<PowerUp> powerUps;
    private ArrayList<Wall> walls;
    private ArrayList<Bullet> bullets;

    public Player collidedPlayer;
    public Enemy collidedEnemy;
    public PowerUp collidedPowerUp;
    public Wall collidedWall;
    public Bullet collidedBullet;


    public CollisionComponent() {
        collisionListener = new CollisionListener();
        actor = null;

        player = null;
        enemies = new ArrayList<>();
        powerUps = new ArrayList<>();
        walls = new ArrayList<>();
    }

    public CollisionComponent(AbstractActor actor, Player player, ArrayList<Enemy> enemies, ArrayList<PowerUp> powerUps, ArrayList<Wall> walls) {
        this.actor = actor;
        collisionListener = new CollisionListener();

        this.player = player;
        this.enemies = enemies;
        this.powerUps = powerUps;
        this.walls = walls;
    }

    @Override
    public void update(float deltaT) {
        checkCollision();
    }

    public void checkCollision() {
        for (AbstractActor actor1 : enemies) {
            if (actor.getAABB().collides(actor1.getAABB())) {
                collisionListener.setIsCollidedWithEnemy(true);
                collidedEnemy = (Enemy) actor1;
            }
        }
        for (AbstractActor actor1 : powerUps) {
            if (actor.getAABB().collides(actor1.getAABB())) {
                collisionListener.setIsCollidedWithPowerUp(true);
                collidedPowerUp = (PowerUp) actor1;
            }
        }
        for (AbstractActor actor1 : walls) {
            if (actor.getAABB().collides(actor1.getAABB())) {
                collisionListener.setIsCollidedWithWall(true);
                collidedWall = (Wall) actor1;
            }
        }
        if (actor.getAABB().collides(player.getAABB())) {
            collisionListener.setIsCollidedWithPlayer(true);
            collidedPlayer = player;
        }
        for (Bullet bullet : player.getBullets()) {
            if (actor.getAABB().collides(bullet.getAABB())) {
                collisionListener.setIsCollidedWithBullet(true);
                collidedBullet = bullet;
            }
        }
    }

    public CollisionListener getCollisionListener() {
        return collisionListener;
    }

}
