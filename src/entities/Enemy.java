package entities;

import main.Main;
import util.PictureImport;

import java.awt.image.BufferedImage;

public class Enemy extends Entity{
    private long lastShotTime = 0;
    private int shootCooldown = 2000;
    private static final int RANGE = 500;
    public static int SIZE = (int)(Player.PLAYER_SIZE*0.75);
    public final int spawnPlace;
    public boolean dead = false;
    private static BufferedImage DEAD_BITMAP = PictureImport.importImage("Enemy_Death.png");
    private long lastImgChange = 0;
    private final static BufferedImage img1 = PictureImport.importImage("Enemy_1.png");
    private final static BufferedImage img2 = PictureImport.importImage("Enemy_2.png");


    public Enemy(int xCoordinate, int yCoordinate, int spawn) {
        super(xCoordinate, yCoordinate, SIZE,SIZE, img1);
        spawnPlace = spawn;
    }

    public void update(){
        if(!dead) {
            if (lastImgChange + 200 < System.currentTimeMillis()) {
                lastImgChange = System.currentTimeMillis();
                if (bi != img1) {
                    bi = img1;
                } else bi = img2;
            }
        }
        if(!dead && lastShotTime + shootCooldown <= System.currentTimeMillis() &&
                Math.pow(Main.player.x - x, 2) + Math.pow(Main.player.y - y, 2) <= RANGE * RANGE){

            if(Main.rng(0.3f)){
                shoot();
            }
        }
    }

    private void shoot(){
        Main.hostileParticles.add(new HostileParticle(x, y, (byte)(-1)));
        lastShotTime = System.currentTimeMillis();
        System.out.println("Enemy shot a particle");
    }

    public void die(){
        bi = DEAD_BITMAP;
        dead = true;
        Main.money += Level.level * 20;
    }

}
