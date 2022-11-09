package Actors;

import Util.Position2D;

import java.awt.*;

public class Wall extends AbstractActor {

    private final String spritePath = "./data/img/wall.png";

    public Wall(Position2D<Float> position, int szX, int szY) {
        super(position, szX, szY);
    }

    @Override
    public void update(float deltaT, Graphics2D g) {
        // TODO: or delete
    }

    @Override
    public boolean isDead() {
        // TODO:
        return false;
    }

    public void takeDamage(int damage) {
        System.out.println("Walls do not take damage");
    }
}
