package graphics;

import main.Main;
import util.PictureImport;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Lost {
    private static BufferedImage curImg;
    private static boolean active = false;

    public static void animateLoss(){
        active = true;
        curImg = PictureImport.importImage("default.png");
        BufferedImage bf = PictureImport.importImage("default.png");
        for(BufferedImage i:bf){
            curImg=i;
            Main.panel.repaint();
            try {
                Thread.sleep(1000);
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
