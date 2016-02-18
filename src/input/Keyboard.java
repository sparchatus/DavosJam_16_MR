package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

public class Keyboard implements KeyListener{
    HashSet<Integer> pressedButtons = new HashSet<Integer>();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e){
        pressedButtons.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedButtons.remove(e.getKeyCode());
    }

}
