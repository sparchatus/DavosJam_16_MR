package graphics;

import entities.Enemy;
import input.Keyboard;
import input.Mouse;
import main.Main;
import main.Upgrade;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public static int upgradeBarHeight;
    public static int upgradeIconSize;


    public GamePanel(){
        this.setBackground(Color.PINK);
        this.addKeyListener(new Keyboard());
        this.addMouseListener(new Mouse());
    }
    @Override
    protected void paintComponent(Graphics g){
        upgradeBarHeight = this.getHeight() / 10;
        upgradeIconSize = upgradeBarHeight / 2;
        g.setColor(new Color(0xffe4e1));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        render(g);
    }

    private void render(Graphics g){
        if(Main.level!=null)Main.level.render(g);
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, this.getWidth(), upgradeBarHeight);
        Upgrade.size = GamePanel.upgradeIconSize;
        Upgrade.y = (GamePanel.upgradeBarHeight - GamePanel.upgradeIconSize) / 2;
        if((Integer)this.getWidth() != null) {
            for (int i = 0; i < Main.upgrades.length; ++i) {
                Main.upgrades[i].x = i * getWidth() / Main.upgrades.length + Upgrade.size / 2;
            }
        }
        for(int i = 0; i < Main.upgrades.length; ++i){
            if(Main.upgrades[i] != null)
            Main.upgrades[i].render(g);
        }
        // render life
        g.setColor(Color.BLACK);
        g.drawString(Main.money + "$", this.getWidth() - 150, Upgrade.y + (Upgrade.size + g.getFont().getSize()) / 2);
        if(Main.player!=null)Main.player.render(g);
        for(Enemy e:Main.activeEnemies){
            e.render(g);
        }
    }
}
