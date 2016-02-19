package entities;

import input.Keyboard;
import main.Main;
import util.PictureImport;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{

    public static int maxLife;
    public static int life;
    public static int speed=5;
    private static boolean moving = false;
    private BufferedImage img, img1, _img, _img1;
    long lastImgChange = 0;
    private final int ATTACK_DURATION = Main.TICKS*2;
    private final int ATTACK_COOLDOWN = Main.TICKS*6;
    public static int PLAYER_SIZE=256;
    public static int WALK_BORDER_LEFT = PLAYER_SIZE/2;
    public static int WALK_BORDER_RIGHT = PLAYER_SIZE*3;

    private int lastAttackChange=0;
    private boolean attacking = false;

    public Player(int xCoordinate, int yCoordinate){
        super(xCoordinate,yCoordinate, PLAYER_SIZE, PLAYER_SIZE, PictureImport.importImage("Einhorn_1.png"));
        maxLife = 1000;
        life = maxLife;
        _img=img = PictureImport.importImage("Einhorn_1.png");
        _img1=img1 = PictureImport.importImage("Einhorn_2.png");
    }

    public void render(Graphics g){
        if(!moving){
            super.render(g);
            return;
        }
        if(speed>0){
            if(System.currentTimeMillis() - 100 > lastImgChange){
                if(bi != img1){
                    bi = img1;
                } else bi = img;
                lastImgChange = System.currentTimeMillis();
            }
        } else if(speed < 0){
            if(System.currentTimeMillis() - 100 > lastImgChange){
                if(bi != _img){
                    bi = _img;
                } else bi = _img1;
                lastImgChange = System.currentTimeMillis();
            }
        }
        super.render(g);
    }

    @Override
    public void update() {
        if(Keyboard.getPressedKeys(65))move(-1);
        else if(Keyboard.getPressedKeys(68))move(1);
        else moving = false;
        if(Keyboard.getPressedKeys(32)){
            startAttack();
        }
        if(attacking&&(lastAttackChange+ATTACK_DURATION<=Main.tick)){
            attacking = false;
            lastAttackChange = Main.tick;
        }
    }

    private void startAttack(){
        if(!attacking&&(lastAttackChange+ATTACK_COOLDOWN)<=Main.tick){
            attacking = true;
            lastAttackChange = Main.tick;
        }
    }
    private void move(int i){
        if(i==1){
            speed=Math.abs(speed);
        }else{
            speed=-Math.abs(speed);
        }
        moving=true;
        x+=speed;
        int want = x;
        if(x<WALK_BORDER_LEFT){
            x=WALK_BORDER_LEFT;
            Main.level.move(x-want);
            moving=false;
        }else if(x>Main.panel.getWidth()-WALK_BORDER_RIGHT){
            x = Main.panel.getWidth()-WALK_BORDER_RIGHT;
            Main.level.move(x-want);
            moving = false;
        }
    }
}
