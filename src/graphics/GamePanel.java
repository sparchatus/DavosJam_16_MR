package graphics;

import entities.Enemy;
import input.Keyboard;
import input.Mouse;
import main.Main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private static final int UPGRADE_BAR_HEIGHT = Main.frame.getHeight() / 10;


    public GamePanel(){
        this.setBackground(Color.PINK);
        this.addKeyListener(new Keyboard());
        this.addMouseListener(new Mouse());
    }
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(new Color(0xffe4e1));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawLine(0, 0, 150, 200);
        render(g);
    }

    private void render(Graphics g){
        Main.player.render(g);
        for(Enemy e:Main.activeEnemies){
            e.render(g);
        }
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, this.getWidth(), UPGRADE_BAR_HEIGHT);

    }
}
