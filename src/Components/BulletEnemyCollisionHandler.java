package Components;

import Actors.Bullet;
import Actors.Enemy;

import java.util.ArrayList;

public class BulletEnemyCollisionHandler implements IRealTimeComponent {
    private Bullet bullet;
    private ArrayList<Enemy> enemies;
    private boolean isCollided;
    private Enemy collidedEnemy;

    public BulletEnemyCollisionHandler(Bullet bullet, ArrayList<Enemy> enemies) {
        this.bullet = bullet;
        this.enemies = enemies;
        collidedEnemy = null;
        isCollided = false;
    }

    @Override
    public void update(float deltaT) {
        checkCollision();
    }

    public void checkCollision() {
        for (Enemy enemy : enemies) {
            if (bullet.getAABB().collides(enemy.getAABB())) {
                isCollided = true;
                collidedEnemy = enemy;
                collidedEnemy.setIsAlive(false);
                enemies.remove(enemy);
                break;
            }
        }
    }

    public boolean getIsCollided() {
        return isCollided;
    }

    public Enemy getCollidedEnemy() {
        return collidedEnemy;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
}
