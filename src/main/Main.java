package main;

import com.sun.javafx.geom.Vec2f;
import entities.Enemy;
import entities.Player;
import graphics.GamePanel;

import javax.swing.*;
import java.util.ArrayList;

public class Main extends Thread{
    private static JFrame frame = new JFrame("MASTERRACE");
    private static GamePanel panel = new GamePanel();
    private static long lastCycleTime = 0;
    private static final int TICKS = 30;
    private static Vec2f mouseClick;

    private Player player = new Player(0,0);
    private ArrayList<Enemy> activeEnemies=new ArrayList<>();


    public static void main(String [ ] args){
        frame.setSize(720, 480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setSize(frame.getSize());
        frame.add(panel);
        frame.setVisible(true);
        new Main().start();
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
        mouseClick = null;
    }

    public static void setMouseClick(Vec2f vec){
        mouseClick = vec;
    }
}












