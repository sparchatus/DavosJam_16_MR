import entities.Enemy;
import entities.Player;
import graphics.GamePanel;

import javax.swing.*;
import java.util.ArrayList;

public class Main extends Thread{
    public static JFrame frame = new JFrame("MASTERRACE");
    public static GamePanel panel = new GamePanel();

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
            update();
            panel.repaint();
        }
    }

    public void update(){

    }
}












