package Components;

public class CollisionListener implements ICollisionListener {

    private boolean isCollided;
    private boolean isCollidedWithEnemy;
    private boolean isCollidedWithPlayer;
    private boolean isCollidedWithPowerUp;
    private boolean isCollidedWithWall;
    private boolean isCollidedWithBullet;

    public CollisionListener() {
        isCollided = false;
        isCollidedWithEnemy = false;
        isCollidedWithPlayer = false;
        isCollidedWithPowerUp = false;
        isCollidedWithWall = false;
        isCollidedWithBullet = false;

    }

    @Override
    public void aCollisionIsHappened() {
        isCollided = true;
    }

    public boolean getIsCollided() {
        return isCollided;
    }

    public void setIsCollided(boolean isCollided) {
        this.isCollided = isCollided;
    }

    public void setIsCollidedWithEnemy(boolean isCollidedWithEnemy) {
        this.isCollidedWithEnemy = isCollidedWithEnemy;
    }

    public void setIsCollidedWithPlayer(boolean isCollidedWithPlayer) {
        this.isCollidedWithPlayer = isCollidedWithPlayer;
    }

    public void setIsCollidedWithPowerUp(boolean isCollidedWithPowerUp) {
        this.isCollidedWithPowerUp = isCollidedWithPowerUp;
    }

    public void setIsCollidedWithWall(boolean isCollidedWithWall) {
        this.isCollidedWithWall = isCollidedWithWall;
    }

    public boolean getIsCollidedWithEnemy() {
        return isCollidedWithEnemy;
    }

    public boolean getIsCollidedWithPlayer() {
        return isCollidedWithPlayer;
    }

    public boolean getIsCollidedWithPowerUp() {
        return isCollidedWithPowerUp;
    }

    public boolean getIsCollidedWithWall() {
        return isCollidedWithWall;
    }

    public void setIsCollidedWithBullet(boolean isCollidedWithBullet) {
        this.isCollidedWithBullet = isCollidedWithBullet;
    }

    public boolean getIsCollidedWithBullet() {
        return isCollidedWithBullet;
    }


}
