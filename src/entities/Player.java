package entities;

import util.PictureImport;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{

    private int maxLife;
    private int life;
    private BufferedImage img;

    public Player(int xCoordinate, int yCoordinate){
        super(xCoordinate,yCoordinate);
        maxLife = 1000;
        life = maxLife;
        img= PictureImport.importImage("player.png");
    }

    public void render(Graphics g){
        g.drawImage(img,x,y,null);
    }

}
