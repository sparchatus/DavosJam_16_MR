package main;

import com.sun.javafx.geom.Vec2f;
import entities.*;
import entities.levels.Level1;
import graphics.*;
import util.PictureImport;

import javax.swing.*;
import java.util.ArrayList;

public class Main extends Thread{
    public static JFrame frame = new JFrame("MASTERRACE");
    public static GamePanel panel;
    private static long lastCycleTime = 0;
    public static Horn horn = new Horn();
    public static final int TICKS = 30;
    public static int tick=0;
    public static Vec2f mouseClick;
    public static boolean running=false;
    public static boolean won=false;
    public static boolean restart = false;

    public static Level level;
    public static int money = 0;
    public static Upgrade[] upgrades = new Upgrade[3];
    public static Player player;
    public static Prince prince;
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
        upgrades[0] = new Upgrade("Horn", PictureImport.importImage("Upgrade_Horn.png"), 1000);
        upgrades[1] = new Upgrade("Health", PictureImport.importImage("Upgrade_Health.png"), 350);
        upgrades[2] = new Upgrade("Speed", PictureImport.importImage("Upgrade_Speed.png"), 200);
        prince = new Prince();
    }

    private static void startDataSetup(){
        won=false;
        restart=false;
        running = true;
        tick = 0;
        level = new Level1();
    }

    public void run(){
        //Start.animateStart();
        do {
            System.out.println("start of game loop");
            startDataSetup();
            System.out.println("entering while");
            while (running) {
                won();
                System.out.println("tick:"+tick);
                if (System.currentTimeMillis() > lastCycleTime + 1000 / TICKS) {
                    lastCycleTime = System.currentTimeMillis();
                    update();
                    panel.repaint();
                    ++tick;
                }
                try {
                    Thread.sleep(1000 / TICKS - (System.currentTimeMillis() - lastCycleTime));
                } catch (Exception e) {
                    //ignore
                }
            }
            System.out.println("exit while");
            if (won) {
                System.out.println("animating win");
                Won.animateWin();
            } else {
                System.out.println("animating loss");
                Lost.animateLoss();
            }
            System.out.println("asking restart");
            Restart.askRestart();
            System.out.println("out of restart with:" + restart);
        }while(restart);
    }

    private synchronized void update(){
        if(Player.life==0){
            lost();
        }
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
                        if(Horn.h == 1){
                            Horn.h = 2;
                            Horn.horn = Horn.horn2;
                            Horn.attackHorn = Horn._horn2;
                        } else if(Horn.h == 2){
                            Horn.h = 3;
                            Horn.horn = Horn.horn3;
                            Horn.attackHorn = Horn._horn3;
                        } else if(Horn.h == 3){
                            Horn.h = 4;
                            Horn.horn = Horn.horn4;
                            Horn.attackHorn = Horn._horn4;
                        } else if(Horn.h == 4){
                            Horn.h = 1;
                            Horn.horn = Horn.horn1;
                            Horn.attackHorn = Horn._horn1;
                        }

                        Horn._horn = PictureImport.flip(Horn.horn);
                        Horn._attackHorn = PictureImport.flip(Horn.attackHorn);

                    }

                }
            }
            if(mouseClick.y > 90){
                player.startAttack();
            }
        }
        level.update();
        for(Enemy e : activeEnemies){
            e.update();
        }
        ArrayList<HostileParticle> remove=new ArrayList<>();
        for(HostileParticle h : hostileParticles){
            h.update();
            if(h.checkHit())remove.add(h);
        }
        for(HostileParticle r : remove){
            hostileParticles.remove(r);
            System.out.println("Particle removed!");
        }
        player.update();
        prince.update();
        horn.update();
        mouseClick = null;
        if(rainbows.size() > 100) rainbows.remove(0);
    }

    public static void setMouseClick(Vec2f vec){
        mouseClick = vec;
    }

    public static boolean rng(float chance){
        if(Math.random() < chance)return true;
        return false;
    }

    public static void lost() {
        running = false;
        won=false;
    }

    public static void won() {
        running = false;
        won=true;
    }
}












