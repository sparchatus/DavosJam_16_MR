package entities;

import main.Main;
import util.PictureImport;

public class HostileParticle extends Entity{
    private static int SIZE = 50;
    private final int DMG = 100;
    private final int SPEED = 10;
    private int speed;

    public HostileParticle(int x, int y, byte direction){
        super(x, y, SIZE, SIZE,PictureImport.importImage("Einhorn_1.png"));
        speed = direction*SPEED;
    }

    public void update(){
        x += speed;
    }

    public boolean checkHit() {
        if(x<0||x>Level.length||y<0||y> Main.panel.getHeight())return true;
        if(Level.getSolid(x,y)) return true;
        if(x>Main.player.x&&x<Main.player.x+Player.PLAYER_SIZE&&y>Main.player.y&&y<Main.player.y-Player.PLAYER_SIZE)return playerHit();
        return false;
    }

    private boolean playerHit(){
        Main.player.life-=DMG;
        return true;
    }
}
