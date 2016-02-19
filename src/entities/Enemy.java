package entities;

import main.Main;
import util.PictureImport;

public class Enemy extends Entity{
    private long lastShotTime = 0;
    private int shootCooldown = 2000;
    private static final int RANGE = 500;
    public static int SIZE = (int)(Player.PLAYER_SIZE*0.75);
    public final int spawnPlace;



    public Enemy(int xCoordinate, int yCoordinate, int spawn) {
        super(xCoordinate, yCoordinate, SIZE,SIZE, PictureImport.importImage("Enemy_1.png"));
        spawnPlace = spawn;
    }

    public void update(){
        if(lastShotTime + shootCooldown <= System.currentTimeMillis() &&
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

}
