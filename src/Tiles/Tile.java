package Tiles;

import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage img;
    public TileTypes type;
    public boolean solid;

    public  Tile(BufferedImage i, TileTypes t, boolean s){
        img = i;
        type = t;
        solid = s;
    }
}
