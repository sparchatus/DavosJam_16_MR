package input;

import main.Main;

import com.sun.javafx.geom.Vec2f;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked");
        Main.setMouseClick(new Vec2f(e.getX(), e.getY()));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
