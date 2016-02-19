package main;

import com.sun.javafx.geom.Vec2f;
import entities.*;
import graphics.GamePanel;

import javax.swing.*;
import java.util.ArrayList;

public class Main extends Thread{
    public static JFrame frame = new JFrame("MASTERRACE");
    public static GamePanel panel;
    private static long lastCycleTime = 0;
    public static final int TICKS = 30;
    public static int tick=0;
    private static Vec2f mouseClick;

    public static Level level;
    public static int money = 1000000;
    public static Upgrade[] upgrades = new Upgrade[3];
    public static Player player;
    public static ArrayList<Enemy> activeEnemies=new ArrayList<>();
    public static ArrayList<HostileParticle> hostileParticles = new ArrayList<>();
    public static ArrayList<Rainbow> rainbows = new ArrayList<>();
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
        new Main().start();
    }

    private static void loadStuff(){
        player = new Player(Player.WALK_BORDER_LEFT,panel.getHeight()-Player.PLAYER_SIZE);
        activeEnemies.add(new Enemy(0,700));
        upgrades[0] = new Upgrade("Horn", null, 10); //todo: update this stuff
        upgrades[1] = new Upgrade("Health", null, 10);
        upgrades[2] = new Upgrade("Speed", null, 10);
        level = new Level();
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
        if(mouseClick != null) {
            for (Upgrade u : upgrades) {
                if (money >= u.cost && mouseClick.x >= u.x && mouseClick.x <= u.x + Upgrade.size && mouseClick.y >= Upgrade.y
                        && mouseClick.y <= Upgrade.y + Upgrade.size) {
                    u.buy();
                    System.out.println("upgrade bought");
                    if(u.NAME.equals("Speed")){
                        Player.speed += Player.speed / Math.abs(Player.speed) * 2;
                    } else if(u.NAME.equals("Health")){
                        Player.maxLife *= 1.2f;
                        Player.life *= 1.2f;
                    } else{
                        // todo: upgrade horn
                    }

                }
            }
        }
        for(Enemy e : activeEnemies){
            e.update();
        }
        for(HostileParticle h : hostileParticles) h.update();
        player.update();
        mouseClick = null;
    }

    public static void setMouseClick(Vec2f vec){
        mouseClick = vec;
    }

    public static boolean rng(float chance){
        if(Math.random() < chance)return true;
        return false;
    }
}












