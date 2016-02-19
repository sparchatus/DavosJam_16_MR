package graphics;

import entities.Enemy;
import entities.HostileParticle;
import input.Keyboard;
import input.Mouse;
import main.Main;
import main.Upgrade;
import util.PictureImport;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    public static int upgradeBarHeight;
    public static int upgradeIconSize;
    private static BufferedImage top_ui;


    public GamePanel(){
        this.setBackground(Color.PINK);
        this.addKeyListener(new Keyboard());
        this.addMouseListener(new Mouse());
        top_ui= PictureImport.importImage("UI_top.png");
    }
    @Override
    protected void paintComponent(Graphics g){
        upgradeBarHeight = this.getHeight() / 10;
        upgradeIconSize = upgradeBarHeight / 2;
        g.setColor(new Color(0xffe4e1));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        if(Main.running)render(g);
        else renderSpecial(g);
    }

    private void render(Graphics g){
        if(Main.level!=null)Main.level.render(g);
        g.drawImage(top_ui,0,0,1600,90,null);
        Upgrade.size = GamePanel.upgradeIconSize;
        Upgrade.y = (GamePanel.upgradeBarHeight - GamePanel.upgradeIconSize) / 2;

        for(int i = 0; i < Main.upgrades.length; ++i){
            if(Main.upgrades[i] != null)
            Main.upgrades[i].render(g);
        }
        for (int i = 0; i < Main.rainbows.size(); ++i) {
            Main.rainbows.get(i).render(g);
        }
        for(HostileParticle h : Main.hostileParticles){
            h.render(g);
        }
        // render life
        g.setColor(Color.BLACK);
        g.drawString(Main.money + "$", this.getWidth() - 150, Upgrade.y + (Upgrade.size + g.getFont().getSize()) / 2);
        if(Main.player!=null)Main.player.render(g);
        Main.prince.render(g);
        Main.horn.render(g);
        for(Enemy e:Main.activeEnemies){
            e.render(g);
        }
        try {
            for (int i = 0; i < Main.upgrades.length; ++i) {
                Main.upgrades[i].x = i * getWidth() / Main.upgrades.length + Upgrade.size / 2;
            }
        }catch (Exception e){}
    }

    private void renderSpecial(Graphics g){
        Start.render(g);
        Lost.render(g);
        Won.render(g);
        Restart.render(g);
    }
}
