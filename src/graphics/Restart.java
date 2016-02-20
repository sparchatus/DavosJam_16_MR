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
        //x,y,w,h
        int exit[]=new int[4];
        int restart[]=new int[4];
        if(!Main.won){
            curImg = PictureImport.importImage("Game_Over.png");
            exit[0]=1072;
            exit[1]=66;
            exit[2]=474;
            exit[3]=305;
            restart[0]=19;
            restart[1]=561;
            restart[2]=369;
            restart[3]=233;
        }else{
            curImg = PictureImport.importImage("Game_Victory.png");
            exit[0]=34;
            exit[1]=611;
            exit[2]=718;
            exit[3]=266;
            restart[0]=842;
            restart[1]=611;
            restart[2]=718;
            restart[3]=266;
        }
        Main.panel.repaint();
        while(true){
            System.out.println("waiting for click");
            Vec2f cl = Main.mouseClick;
            if(cl!=null){
                if(cl.x>restart[0]&&cl.x<restart[0]+restart[2]&&cl.y>restart[1]&&cl.y<restart[1]+restart[3]){
                    Main.restart=true;
                    break;
                }else if(cl.x>exit[0]&&cl.x<exit[0]+exit[2]&&cl.y>exit[1]&&cl.y<exit[1]+exit[3]){
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
