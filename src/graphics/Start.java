package graphics;

import main.Main;
import util.PictureImport;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Start {

    private static BufferedImage curImg;
    private static boolean active = false;

    public static void animateStart(){
        active = true;
        Main.running = false;
        curImg = PictureImport.importImage("default.png");
        BufferedImage bf[]= new BufferedImage[4];
        bf[0]=PictureImport.importImage("Begin_1.png");
        bf[1]=PictureImport.importImage("Begin_2.png");
        bf[2]=PictureImport.importImage("Begin_3.png");
        bf[3]=PictureImport.importImage("Begin_4.png");
        for(BufferedImage i:bf){
            curImg=i;
            Main.panel.repaint();
            try {
                Thread.sleep(3000);
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
