package entities;

import main.Main;
import util.PictureImport;

import java.awt.image.BufferedImage;

public class HostileParticle extends Entity{
    private static int SIZE = 50;
    private final int DMG;
    private final int SPEED = 10;
    private int speed;
    private static BufferedImage img1, img2, img3;
    private static BufferedImage _img1, _img2, _img3;

    public HostileParticle(int x, int y, byte direction){
        super(x, y, SIZE, SIZE,PictureImport.importImage("Einhorn_1.png"));
        if(img1==null){
            img1=PictureImport.importImage("Particle_Stone.png");
            _img1 = PictureImport.flip(img1);
            img2=PictureImport.importImage("Particle_Knife.png");
            _img2 = PictureImport.flip(img2);
            img3=PictureImport.importImage("Particle_Ball.png");
            _img3 = PictureImport.flip(img3);
        }
        if(Main.rng(0.6f)){
            if(direction == 1) bi = _img1;
            else bi=img1;
            DMG=1200;
        }else if(Main.rng(0.75f)){
            if(direction == 1) bi = _img2;
            else bi=img2;
            DMG=3000;
        }else{
            if(direction == 1) bi = _img3;
            else bi=img3;
            DMG=6000;
        }
        speed = direction*SPEED;
    }

    public void update(){
        x += speed;
    }

    public boolean checkHit() {
        if(x<0||x>Level.length||y<0||y> Main.panel.getHeight())return true;
        if(Level.getSolid(x,y)) return true;
        if(x>Main.player.x+20&&x<Main.player.x+Player.PLAYER_SIZE-20&&y>Main.player.y&&y<Main.player.y+Player.PLAYER_SIZE)return playerHit();
        return false;
    }

    private boolean playerHit(){
        Player.life-=DMG;
        return true;
    }
}
