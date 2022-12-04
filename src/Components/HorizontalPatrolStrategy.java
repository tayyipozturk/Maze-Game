package Components;

public class HorizontalPatrolStrategy extends AbstractPatrolStrategy {

    public HorizontalPatrolStrategy(int speed) {
        super.setSpeed(speed);
    }

    @Override
    public void update(float deltaT) {
        setSpeed(getSpeed());
    }
}
