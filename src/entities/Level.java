package entities;

import Tiles.Tile;
import Tiles.TileTypes;
import main.Main;
import util.PictureImport;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Level extends Entity{

    private static ArrayList<Enemy>enemiesToSpawn=new ArrayList<>();
    private final int WIDTH = 20;
    private final int HEIGHT = 6;
    private final int TILE_SIDE = 64;
    private static int TILE_SCREEN_SIZE;
    public static Tile[][] levelMap = new Tile[6][20];

    public Level() {
        super(0, 0);
        TILE_SCREEN_SIZE = Main.panel.getHeight()/HEIGHT;
        setTiles("Level_1.png");
    }

    public static void setTiles(String pixelFile){
        BufferedImage pixel = PictureImport.importImage(pixelFile);
        if(pixel==null){
            System.out.println("pixel map not found");
        }
        Tile earth, floor, sky;
        earth = new Tile(PictureImport.importImage("Tile_Earth.png"), TileTypes.EARTH, true);
        floor = new Tile(PictureImport.importImage("Tile_Floor.png"), TileTypes.FLOOR, true);
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

    public void move(int speed){
        x+=speed;
        if(x>0)x=0;
        else if(x<WIDTH*TILE_SCREEN_SIZE)x=WIDTH*TILE_SCREEN_SIZE;
    }
    public void render(Graphics g){
        for(int i = 0; i < levelMap.length; ++i) {
            for (int j = 0; j < levelMap[0].length; ++j) {
                int xc = j*TILE_SCREEN_SIZE+x;
                int yc = i*TILE_SCREEN_SIZE;
                if(xc<-TILE_SCREEN_SIZE||xc>Main.panel.getWidth()){
                    continue;
                }
                g.drawImage(levelMap[i][j].img,xc,yc,TILE_SCREEN_SIZE, TILE_SCREEN_SIZE, null);
            }
        }
    }
}
