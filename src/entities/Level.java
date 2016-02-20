package entities;

import Tiles.Tile;
import entities.levels.Level2;
import entities.levels.Level3;
import entities.levels.Level4;
import entities.levels.Level5;
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
    public static Tile earth, floor, sky, castleB, castleT, doorBL, castleW, castleJ, doorBR, doorTL, doorTR;
    public static Tile[][] levelMap = new Tile[6][20];
    public static int level;


    public Level(int end, String map) {
        super(0,0,0,0,null);
        TILE_SCREEN_SIZE = Main.panel.getHeight()/HEIGHT;
        END = end;
        earth = new Tile(PictureImport.importImage("Tile_Earth.png"), true);
        floor = new Tile(PictureImport.importImage("Tile_Floor.png"), false);
        sky = new Tile(PictureImport.importImage("Tile_Sky.png"), false);
        castleB = new Tile(PictureImport.importImage("Castle_bottom_1.png"), false);
        castleT = new Tile(PictureImport.importImage("Castle_Texture.png"), false);
        doorBL = new Tile(PictureImport.importImage("Door_Bottom_Left.png"), false);
        doorBR = new Tile(PictureImport.importImage("Door_Bottom_Right.png"), false);
        doorTL = new Tile(PictureImport.importImage("Door_Top_Left.png"), false);
        doorTR = new Tile(PictureImport.importImage("Door_Top_Right.png"), false);
        castleW = new Tile(PictureImport.importImage("Castle_Window.png"), false);
        castleJ = new Tile(PictureImport.importImage("Castle_Jail.png"), false);

        setTiles(map);
    }

    public static void setTiles(String pixelFile){
        BufferedImage pixel = PictureImport.importImage(pixelFile);
        length = pixel.getWidth()*TILE_SCREEN_SIZE;
        levelMap=new Tile[pixel.getHeight()][pixel.getWidth()];

        for(int i = 0; i < pixel.getHeight(); ++i){
            for(int j = 0; j < pixel.getWidth(); ++j){
                int t = pixel.getRGB(j,i);
                if(t==0xff000000){
                    levelMap[i][j]=earth;
                }else if(t==0xffffffff){
                    levelMap[i][j]=floor;
                }else if(t==0xff00ff00){
                    levelMap[i][j]=castleB;
                }else if(t==0xff0026ff){
                    levelMap[i][j]=castleT;
                }else if(t==0xff00ffff){
                    levelMap[i][j]=doorBL;
                }else if(t==0xffb6ff00){
                    levelMap[i][j]=doorBR;
                }else if(t==0xffff6a00){
                    levelMap[i][j]=doorTL;
                }else if(t==0xffff0000){
                    levelMap[i][j]=doorTR;
                }else if(t==0xff7f006e){
                    levelMap[i][j]=castleJ;
                }else if(t==0xffff006e){
                    levelMap[i][j]=castleW;
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
            System.out.println("level changed");
            switch(level){
                case 1:Main.level = new Level2();
                    break;
                case 2:Main.level = new Level3();
                    break;
                case 3:Main.level = new Level4();
                    break;
                case 4:Main.level = new Level5();
                    break;
                case 5:Main.won();
            }
            Main.player.setBack();
            rCL=0;
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
