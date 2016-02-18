package entities;

import Tiles.Tile;
import Tiles.TileTypes;
import util.PictureImport;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Level {

    private static ArrayList<Enemy>enemiesToSpawn=new ArrayList<>();
    public static Tile[][] levelMap = new Tile[6][20];

    public Level(){
        setTiles("def");
    }

    public static void setTiles(String pixelFile){
        BufferedImage pixel = PictureImport.importImage(pixelFile);
        Tile earth, floor, sky;
        earth = new Tile(PictureImport.importImage("res/Tile_Earth.png"), TileTypes.EARTH, true);
        floor = new Tile(PictureImport.importImage("res/Tile_Floor.png"), TileTypes.FLOOR, true);
        sky = new Tile(PictureImport.importImage("default"), TileTypes.SKY, false);

        for(int i = 0; i < pixel.getHeight(); ++i){
            for(int j = 0; j < pixel.getWidth(); ++j){
                int t = pixel.getRGB(j,i);
                if(t==0x000000){
                    levelMap[i][j]=earth;
                }else if(t==0xffffff){
                    levelMap[i][j]=floor;
                }else{
                    levelMap[i][j]=sky;
                }
            }
        }

    }

    public void render(){

    }
}
