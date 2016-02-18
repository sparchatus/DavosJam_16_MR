package graphics;

import entities.Enemy;
import main.Main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel(){
        this.setBackground(Color.PINK);
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
    }
}
