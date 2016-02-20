package graphics;

import main.Main;
import util.PictureImport;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Won {
    private static BufferedImage curImg;
    private static boolean active = false;
    public static int x,y;
    private static boolean pfy=false;
    private static BufferedImage prinz;

    public static void animateWin(){
        active = true;
        curImg = PictureImport.importImage("default.png");
        BufferedImage bf[]= new BufferedImage[6];
        bf[0]=PictureImport.importImage("Ending_Win_1.png");
        bf[1]=PictureImport.importImage("Ending_Win_2.png");
        bf[2]=PictureImport.importImage("Ending_Win_3.png");
        bf[3]=PictureImport.importImage("Ending_Win_4.png");
        bf[4]=PictureImport.importImage("Ending_Win_5.png");
        bf[5]=PictureImport.importImage("Ending_Win_6.png");

        prinz = PictureImport.importImage("Ending_Win_6_Prince.png");
        pfy=false;
        for(int i = 0; i < bf.length-1; ++i){
            curImg=bf[i];
            Main.panel.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        x=700;
        y=100;
        pfy=true;
        curImg=bf[bf.length-1];
        while(x>0){
            x-=30;
            y-=8;
            Main.panel.repaint();
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
        if(pfy)g.drawImage(prinz,x,y,500,500,null);
    }
}
