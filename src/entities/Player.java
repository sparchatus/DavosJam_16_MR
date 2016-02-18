package entities;

import util.PictureImport;

import java.awt.*;

public class Player extends Entity{

    private int maxLife;
    private int life;
    private Image img;

    public Player(int xCoordinate, int yCoordinate){
        super(xCoordinate,yCoordinate);
        maxLife = 1000;
        life = maxLife;
        img= PictureImport.importImage();
    }

    public void render(Graphics g){
        g.drawImage();
    }

}
