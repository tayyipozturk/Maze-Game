package Actors;

import Components.SpriteComponent;
import Util.Position2D;

import java.awt.*;
import java.io.IOException;

public class PowerUp extends AbstractActor {
    // TODO:
    private final SpriteComponent spriteComponent = new SpriteComponent("./data/img/scroll.png");

    public PowerUp(Position2D<Float> position, float szX, float szY) throws IOException {
        super(position, szX, szY);
    }

    @Override
    public void update(float deltaT, Graphics2D g) {
        // TODO or delete
        spriteComponent.draw(g, this.getAABB());
    }

    @Override
    public boolean isDead() {
        // TODO: If collides with a player, it dies.
        return false;
    }


}
