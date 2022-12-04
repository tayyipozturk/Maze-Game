package Components;

public abstract class AbstractPatrolStrategy implements IRealTimeComponent {
    private int speed;

    @Override
    public void update(float deltaT) {
        System.err.println("ERROR: AbstractPatrolStrategy.update() is not implemented.");
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
