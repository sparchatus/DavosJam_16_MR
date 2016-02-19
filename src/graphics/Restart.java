package graphics;

import util.PictureImport;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Restart {

    private static BufferedImage curImg;
    private static boolean active = false;

    public static void askRestart(){
        active = true;
        curImg = PictureImport.importImage("default.png");
        //do stuff
        active = false;
    }

    public static void render(Graphics g){
        if(!active)return;
        g.drawImage(curImg,0,0,1600,900,null);
    }
}
