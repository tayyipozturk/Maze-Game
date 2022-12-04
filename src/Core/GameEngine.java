package Core;

import Actors.*;
import Components.*;
import Util.AABB;
import Util.GameMapLoader;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class GameEngine {
    private final Dimension screenSize;
    private final String currentMap;

    private Player player;
    private ArrayList<Wall> walls;
    private ArrayList<Enemy> enemies;
    private ArrayList<PowerUp> powerUps;
    private ArrayList<Bullet> bulletsInCirculation;
    private ArrayList<IRealTimeComponent> miscComponents;

    private void ResetGame() {
        bulletsInCirculation.clear();
        walls.clear();
        enemies.clear();
        powerUps.clear();

        GameMapLoader map = new GameMapLoader(screenSize);
        boolean mapOK = map.loadMap(this.currentMap);

        if (!mapOK) {
            System.out.println("Util.Map Load Failed!");
            System.exit(1);
        }

        instantiateAllActors(map);
        ArrayList<AbstractActor> collisionBoxes = new ArrayList<>();
        collisionBoxes.addAll(walls);
        collisionBoxes.addAll(enemies);
        collisionBoxes.addAll(powerUps);
        collisionBoxes.add(player);
        for (AbstractActor actor : collisionBoxes) {
            CollisionComponent collisionComponent = new CollisionComponent(actor, player, enemies, powerUps, walls);
            actor.addCollisionComponent(collisionComponent);
            miscComponents.add(collisionComponent);
        }

        for (Bullet bullet : player.getBullets()) {
            BulletEnemyCollisionHandler bulletEnemyCollisionHandler = new BulletEnemyCollisionHandler(bullet, enemies);
            bullet.attachBulletEnemyCollisionHandler(bulletEnemyCollisionHandler);
            miscComponents.add(bulletEnemyCollisionHandler);
        }
    }

    public GameEngine(String mapFilePath, Dimension screenSize) {
        this.currentMap = mapFilePath;
        this.screenSize = screenSize;

        this.walls = new ArrayList<Wall>();
        this.enemies = new ArrayList<Enemy>();
        this.powerUps = new ArrayList<PowerUp>();
        this.bulletsInCirculation = new ArrayList<Bullet>();
        this.miscComponents = new ArrayList<IRealTimeComponent>();

        ResetGame();

    }

    public synchronized void update(float deltaT, Graphics2D currentDrawBuffer) {
        // Do update first
        walls.forEach(actor -> actor.update(deltaT, currentDrawBuffer));
        enemies.forEach(actor -> actor.update(deltaT, currentDrawBuffer));
        powerUps.forEach(actor -> actor.update(deltaT, currentDrawBuffer));
        bulletsInCirculation.forEach(actor -> actor.update(deltaT, currentDrawBuffer));
        player.update(deltaT, currentDrawBuffer);
        miscComponents.forEach(c -> c.update(deltaT));
        // Now stuff would die etc. check the states and delete
        enemies.removeIf(actor -> actor.isDead());
        powerUps.removeIf(actor -> actor.isDead());
        bulletsInCirculation.removeIf(actor -> actor.isDead());
        // If player dies game is over reset the system
        if (player.isDead()) {
            ResetGame();
        }
        // If there are no power-ups left,
        // Player won the game!, still reset..
        if (powerUps.isEmpty()) {
            ResetGame();
        }
        // And the game goes on forever...
    }

    private void instantiateAllActors(GameMapLoader map) {
        instantiateEnemies(map);
        instantiatePlayer(map);
        instantiatePowerUps(map);
        instantiateWalls(map);
    }

    public void instantiateEnemies(GameMapLoader map) {
        for (AABB enemy : map.getLoadedEnemyStationaryAABBs()) {
            try {
                enemies.add(new Enemy(enemy.getPos(), enemy.getSizeX(), enemy.getSizeY(), "Stationary"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        for (AABB enemy : map.getLoadedEnemyXAABBs()) {
            try {
                enemies.add(new Enemy(enemy.getPos(), enemy.getSizeX(), enemy.getSizeY(), "Horizontal"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        for (AABB enemy : map.getLoadedEnemyYAABBs()) {
            try {
                enemies.add(new Enemy(enemy.getPos(), enemy.getSizeX(), enemy.getSizeY(), "Vertical"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void instantiatePlayer(GameMapLoader map) {
        try {
            player = new Player(map.getLoadedPlayerAABB().getPos(), map.getLoadedPlayerAABB().getSizeX(), map.getLoadedPlayerAABB().getSizeY());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void instantiatePowerUps(GameMapLoader map) {
        for (AABB powerUp : map.getLoadedPowerUpAABBs()) {
            try {
                powerUps.add(new PowerUp(powerUp.getPos(), powerUp.getSizeX(), powerUp.getSizeY()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void instantiateWalls(GameMapLoader map) {
        for (AABB wall : map.getLoadedWallAABBs()) {
            try {
                walls.add(new Wall(wall.getPos(), wall.getSizeX(), wall.getSizeY()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
