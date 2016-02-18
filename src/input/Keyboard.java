package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

public class Keyboard implements KeyListener{
    private static HashSet<Integer> pressedKeys = new HashSet<Integer>();

    public static boolean getPressedKeys(int k){
        return pressedKeys.contains(k);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e){
        pressedKeys.add(e.getKeyCode());
        System.out.println("pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }
}
