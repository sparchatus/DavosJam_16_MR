package Tiles;

import java.awt.image.BufferedImage;

/**
 * Created by Sandro on 18/02/2016.
 */
public class Tile {
    public BufferedImage img;
    public TileTypes type;

    public  Tile(BufferedImage i, TileTypes t){
        img = i;
        type = t;
    }
}
