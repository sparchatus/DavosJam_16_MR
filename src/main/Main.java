package main;

import com.sun.javafx.geom.Vec2f;
import entities.Enemy;
import entities.Player;
import graphics.GamePanel;

import javax.swing.*;
import java.util.ArrayList;

public class Main extends Thread{
    public static JFrame frame = new JFrame("MASTERRACE");
    private static GamePanel panel;
    private static long lastCycleTime = 0;
    public static final int TICKS = 30;
    public static int tick=0;
    private static Vec2f mouseClick;

    public static int money = 1111110;
    public static Upgrade[] upgrades = new Upgrade[3];
    public static Player player;
    public static ArrayList<Enemy> activeEnemies=new ArrayList<>();
    public static void main(String [ ] args){
        frame.setSize(1600, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new GamePanel();
        panel.setSize(frame.getSize());
        frame.add(panel);
        frame.setVisible(true);
        panel.setFocusable(true);
        frame.setResizable(false);
        loadStuff();
        player = new Player(0,panel.getHeight()-Player.PLAYER_SIZE);
        new Main().start();
    }

    private static void loadStuff(){
        upgrades[0] = new Upgrade("Horn", null, 10); //todo: update this stuff
        upgrades[1] = new Upgrade("Health", null, 10);
        upgrades[2] = new Upgrade("Speed", null, 10);
        panel.repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Upgrade.size = GamePanel.upgradeIconSize;
        Upgrade.y = (GamePanel.upgradeBarHeight - GamePanel.upgradeIconSize) / 2;
        for(int i = 0; i < upgrades.length; ++i){
            upgrades[i].x = i * panel.getWidth() / Main.upgrades.length + Upgrade.size / 2;

        }
    }

    private void startDataSetup(){

    }

    public void run(){
        startDataSetup();
        while (true){
            if(System.currentTimeMillis() > lastCycleTime + 1000/TICKS){
                lastCycleTime = System.currentTimeMillis();
                update();
                panel.repaint();
                ++tick;
            }
            try{
                Thread.sleep(1000/TICKS - (System.currentTimeMillis() - lastCycleTime));
            }catch(Exception e){
                //ignore
            }
        }
    }

    private synchronized void update(){
        //bla
        if(mouseClick != null) {
            for (Upgrade u : upgrades) {
                if (money >= u.cost && mouseClick.x >= u.x && mouseClick.x <= u.x + Upgrade.size && mouseClick.y >= Upgrade.y
                        && mouseClick.y <= Upgrade.y + Upgrade.size) {
                    u.buy();
                    System.out.println("upgrade bought");
                    //todo: handle individual upgrades

                }
            }
        }
        player.update();
        mouseClick = null;
    }

    public static void setMouseClick(Vec2f vec){
        mouseClick = vec;
    }
}












