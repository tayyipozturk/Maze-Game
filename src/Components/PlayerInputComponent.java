package Components;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerInputComponent implements IRealTimeComponent, KeyListener {
    // Internal States
    private boolean leftPressed;
    private boolean rightPressed;
    private boolean upPressed;
    private boolean downPressed;
    private boolean firePressed;
    // TODO: Add additional properties if required

    // TODO: Implement a constructor
    public PlayerInputComponent() {
        leftPressed = false;
        rightPressed = false;
        upPressed = false;
        downPressed = false;
        firePressed = false;
    }

    @Override
    public void update(float deltaT) {
        // TODO:
    }

    @Override
    public void keyTyped(KeyEvent e) { /* Do nothing */ }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) leftPressed = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) rightPressed = true;
        if (e.getKeyCode() == KeyEvent.VK_UP) upPressed = true;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) downPressed = true;
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
        if (e.getKeyCode() == KeyEvent.VK_SPACE) firePressed = true;
        // TODO: You can also change this code if you want to handle inputs differently
        // this is given as a guideline to read key events
    }
}
