package graphics;

import com.sun.javafx.geom.Vec2f;
import main.Main;
import util.PictureImport;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Restart {

    private static BufferedImage curImg;
    private static boolean active = false;

    public static void askRestart(){
        active = true;
        curImg = PictureImport.importImage("default.png");
        Main.panel.repaint();
        while(true){
            System.out.println("waiting for click");
            Vec2f cl = Main.mouseClick;
            if(cl!=null){
                if(cl.x>=cl.y){
                    Main.restart=true;
                    break;
                }else if(cl.x==cl.y){
                    Main.restart=false;
                    break;
                }
                Main.setMouseClick(null);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        active = false;
    }

    public static void render(Graphics g){
        if(!active)return;
        g.drawImage(curImg,0,0,1600,900,null);
    }
}
