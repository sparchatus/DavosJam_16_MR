package Tiles;

import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage img;
    public boolean solid;

    public  Tile(BufferedImage i,boolean s){
        img = i;
        solid = s;
    }
}
