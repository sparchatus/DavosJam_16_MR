package entities;

import Tiles.Tile;
import Tiles.TileTypes;
import entities.levels.Level2;
import main.Main;
import util.PictureImport;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Level extends Entity{

    protected static ArrayList<Enemy>enemiesToSpawn=new ArrayList<>();
    private final int WIDTH = 20;
    private final int END;
    private final int HEIGHT = 6;
    public static int length;
    private final int TILE_SIDE = 64;
    public static int TILE_SCREEN_SIZE;
    public static Tile[][] levelMap = new Tile[6][20];


    public Level(int end, String map) {
        super(0,0,0,0,null);
        TILE_SCREEN_SIZE = Main.panel.getHeight()/HEIGHT;
        setTiles(map);
        END = end;
    }

    public static void setTiles(String pixelFile){
        BufferedImage pixel = PictureImport.importImage(pixelFile);
        length = pixel.getWidth()*TILE_SCREEN_SIZE;
        if(pixel==null){
            System.out.println("pixel map not found");
        }
        Tile earth, floor, sky;
        earth = new Tile(PictureImport.importImage("Tile_Earth.png"), TileTypes.EARTH, true);
        floor = new Tile(PictureImport.importImage("Tile_Floor.png"), TileTypes.FLOOR, false);
        sky = new Tile(PictureImport.importImage("Tile_Sky.png"), TileTypes.SKY, false);

        for(int i = 0; i < pixel.getHeight(); ++i){
            for(int j = 0; j < pixel.getWidth(); ++j){
                int t = pixel.getRGB(j,i);
                if(t==0xff000000){
                    levelMap[i][j]=earth;
                }else if(t==0xffffffff){
                    levelMap[i][j]=floor;
                }else{
                    levelMap[i][j]=sky;
                }
            }
        }

    }

    public void render(Graphics g){
        for(int i = 0; i < levelMap.length; ++i) {
            for (int j = 0; j < levelMap[0].length; ++j) {
                int xc = j*TILE_SCREEN_SIZE+x;
                int yc = i*TILE_SCREEN_SIZE;
                g.drawImage(levelMap[i][j].img,xc-rCL,yc,TILE_SCREEN_SIZE, TILE_SCREEN_SIZE, null);
            }
        }
    }

    @Override
    public void update() {
        if(Main.player.x>END){
            Main.level = new Level2();
        }
        if(enemiesToSpawn.isEmpty())return;
        while(Main.player.x>enemiesToSpawn.get(0).spawnPlace){
            Main.activeEnemies.add(enemiesToSpawn.get(0));
            enemiesToSpawn.remove(0);
            if(enemiesToSpawn.isEmpty())return;
        }
    }

    public static boolean getSolid(int x, int y){
        x/=TILE_SCREEN_SIZE;
        y/=TILE_SCREEN_SIZE;
        if(x<0||x>=levelMap[0].length)return false;
        if(y<0||y>=levelMap.length)return false;
        return levelMap[y][x].solid;
    }
}
