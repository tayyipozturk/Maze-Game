package Components;

import Core.GameWindow;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerInputComponent implements IRealTimeComponent, KeyListener {
    // Internal States
    private boolean leftPressed;
    private boolean rightPressed;
    private boolean upPressed;
    private boolean downPressed;
    private boolean firePressed;
    private String lastKeyPressed;
    private static PlayerInputComponent instance = new PlayerInputComponent();
    // TODO: Add additional properties if required

    // TODO: Implement a constructor
    private PlayerInputComponent() {
        leftPressed = false;
        rightPressed = false;
        upPressed = false;
        downPressed = false;
        firePressed = false;
        GameWindow.GetInstance().attachKeyListener(this);
    }

    @Override
    public void update(float deltaT) {
        // TODO:
    }

    public static PlayerInputComponent getInstance() {
        return instance;
    }

    @Override
    public void keyTyped(KeyEvent e) { /* Do nothing */ }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
            lastKeyPressed = "left";
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
            lastKeyPressed = "right";
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
            lastKeyPressed = "up";
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
            lastKeyPressed = "down";
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) firePressed = true;
        // TODO: You can also change this code if you want to handle inputs differently
        // this is given as a guideline to read key events
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) leftPressed = false;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) rightPressed = false;
        if (e.getKeyCode() == KeyEvent.VK_UP) upPressed = false;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) downPressed = false;
        // Enforce release operation on fire
        if (e.getKeyCode() == KeyEvent.VK_SPACE) firePressed = false;
        // TODO: You can also change this code if you want to handle inputs differently
        // this is given as a guideline to read key events
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isFirePressed() {
        return firePressed;
    }

    public String getLastKeyPressed() {
        return lastKeyPressed;
    }
}
