package Components;

public abstract class AbstractPatrolStrategy implements IRealTimeComponent {
    private int speed;

    // TODO:
    @Override
    public void update(float deltaT) {
        // TODO:
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void changeDirection() {
        speed = -speed;
    }
}
