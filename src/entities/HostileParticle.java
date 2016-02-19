package entities;

import main.Main;
import util.PictureImport;

import java.awt.image.BufferedImage;

public class HostileParticle extends Entity{
    private static int SIZE = 50;
    private final int DMG;
    private final int SPEED = 10;
    private int speed;
    private static BufferedImage img1, img2;

    public HostileParticle(int x, int y, byte direction){
        super(x, y, SIZE, SIZE,PictureImport.importImage("Einhorn_1.png"));
        if(img1==null){
            img1=PictureImport.importImage("Einhorn_1.png");
            img2=PictureImport.importImage("Einhorn_1.png");
        }
        if(Main.rng(0.5f)){
            bi=img1;
            DMG=200;
        }else{
            bi=img2;
            DMG=100;
        }
        speed = direction*SPEED;
    }

    public void update(){
        x += speed;
    }

    public boolean checkHit() {
        if(x<0||x>Level.length||y<0||y> Main.panel.getHeight())return true;
        if(Level.getSolid(x,y)) return true;
        if(x>Main.player.x&&x<Main.player.x+Player.PLAYER_SIZE&&y>Main.player.y&&y<Main.player.y+Player.PLAYER_SIZE)return playerHit();
        return false;
    }

    private boolean playerHit(){
        Player.life-=DMG;
        return true;
    }
}
