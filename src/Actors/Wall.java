package Actors;

import Components.SpriteComponent;
import Util.Position2D;

import java.awt.*;
import java.io.IOException;

public class Wall extends AbstractActor {

    private final SpriteComponent spriteComponent = new SpriteComponent("./data/img/wall.png");

    public Wall(Position2D<Float> position, float szX, float szY) throws IOException {
        super(position, szX, szY);
    }

    @Override
    public void update(float deltaT, Graphics2D g) {
        // TODO: or delete
        spriteComponent.draw(g, this.getAABB());
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
