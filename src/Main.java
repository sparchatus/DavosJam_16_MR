import graphics.GamePanel;

import javax.swing.*;

public class Main extends Thread{
    public static JFrame frame = new JFrame("MASTERRACE");
    public static GamePanel panel = new GamePanel();


    public static void main(String [ ] args){
        frame.setSize(720, 480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setSize(frame.getSize());
        frame.add(panel);
        frame.setVisible(true);
        new Main().start();
    }

    public void run(){
        while (true){
            panel.repaint();
        }
    }
}












