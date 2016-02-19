package graphics;

import main.Main;
import util.PictureImport;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Won {
    private static BufferedImage curImg;
    private static boolean active = false;

    public static void animateWin(){
        active = true;
        curImg = PictureImport.importImage("default.png");
        BufferedImage bf[]= new BufferedImage[1];
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
