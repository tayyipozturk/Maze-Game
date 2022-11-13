package Components;

public class VerticalPatrolStrategy extends AbstractPatrolStrategy {

    public VerticalPatrolStrategy(int speed) {
        super.setSpeed(speed);
    }

    @Override
    public void update(float deltaT) {
        // TODO:
        setSpeed(getSpeed());
    }
}
