package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity extends Object{

    protected int x, y, sizeX, sizeY;
    protected BufferedImage bi;

    public Entity(int xCoordinate, int yCoordinate, int xSize, int ySize, BufferedImage bufImg){
        x=xCoordinate;
        y=yCoordinate;
        sizeX=xSize;
        sizeY=ySize;
        bi = bufImg;
    }

    public void render(Graphics g){
        if(bi==null)return;
        g.drawImage(bi, x, y, sizeX, sizeY, null);
    }

    public void update(){

    }
}

