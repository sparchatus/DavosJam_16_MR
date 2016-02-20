package entities;

import main.Main;
import util.PictureImport;

import java.awt.image.BufferedImage;

public class Enemy extends Entity{
    private long lastShotTime = 0;
    private int shootCooldown = 500;
    private static final int RANGE = 700;
    public static int SIZE = (int)(Player.PLAYER_SIZE*0.75);
    public final int spawnPlace;
    public boolean dead = false;
    private static BufferedImage DEAD_BITMAP = PictureImport.importImage("Enemy_Death.png");
    private long lastImgChange = 0;
    private final static BufferedImage img1 = PictureImport.importImage("Enemy_1.png");
    private final static BufferedImage img2 = PictureImport.importImage("Enemy_2.png");
    private final static BufferedImage _img1 = PictureImport.flip(img1);
    private final static BufferedImage _img2 = PictureImport.flip(img2);



    public Enemy(int xCoordinate, int spawn) {
        super(xCoordinate, 0, SIZE,SIZE, img1);
        for(int i = Level.levelMap.length - 1; i >= 0; --i){
            if(Level.levelMap[i][(x + (SIZE / 2)) / Level.TILE_SCREEN_SIZE] == Level.floor){
                y = (int)((i - .4f) * Level.TILE_SCREEN_SIZE);
            }
        }

        spawnPlace = spawn;
    }

    public void update(){
        if(!dead) {
            if (lastImgChange + 200 < System.currentTimeMillis()) {
                lastImgChange = System.currentTimeMillis();
                if (x + sizeX / 2 - Main.player.x + Main.player.sizeX / 2 > 0) {
                    if (bi != img1) {
                        bi = img1;
                    } else bi = img2;
                } else{
                    if (bi != _img1) {
                        bi = _img1;
                    } else bi = _img2;
                }
            }
        }
        if(!dead && lastShotTime + shootCooldown <= System.currentTimeMillis() &&
                Math.pow(Main.player.x - x, 2) + Math.pow(Main.player.y - y, 2) <= RANGE * RANGE){

            if(Main.rng(0.07f)){
                shoot();
            }
        }
    }

    private void shoot(){
        byte b = (x + sizeX / 2 - Main.player.x - Main.player.sizeX / 2 > 0) ? (byte)-1 : 1;
        if(b == 1)Main.hostileParticles.add(new HostileParticle(x + sizeX, y, b));
        else Main.hostileParticles.add(new HostileParticle(x, y, b));
        lastShotTime = System.currentTimeMillis();
        System.out.println("Enemy shot a particle");
    }

    public void die(){
        bi = DEAD_BITMAP;
        dead = true;
        Main.money += Level.level * 20;
    }

}
