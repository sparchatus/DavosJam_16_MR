package entities;

import input.Keyboard;
import main.Main;
import util.PictureImport;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{

    public static int maxLife;
    public static int life;
    private int speed=5;
    private BufferedImage img;
    private final int ATTACK_DURATION = Main.TICKS*2;
    private final int ATTACK_COOLDOWN = Main.TICKS*6;
    public static int PLAYER_SIZE=256;
    public static int WALK_BORDER_LEFT = PLAYER_SIZE;
    public static int WALK_BORDER_RIGHT = (int) (PLAYER_SIZE*1.5);

    private int lastAttackChange=0;
    private boolean attacking = false;

    public Player(int xCoordinate, int yCoordinate){
        super(xCoordinate,yCoordinate);
        maxLife = 1000;
        life = maxLife;
        img= PictureImport.importImage("Einhorn_1.png");
    }

    public void render(Graphics g){
        g.drawImage(img,x,y,PLAYER_SIZE,PLAYER_SIZE,null);
    }

    @Override
    public void update() {
        if(Keyboard.getPressedKeys(65))move(-speed);
        if(Keyboard.getPressedKeys(68))move(speed);
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
    private void move(int speed){
        x+=speed;
        int want = x;
        if(x<WALK_BORDER_LEFT){
            x=WALK_BORDER_LEFT;
            Main.level.move(-1);
        }else if(x>Main.panel.getWidth()-WALK_BORDER_RIGHT){
            x = Main.panel.getWidth()-WALK_BORDER_RIGHT;
            Main.level.move(-1);
        }
    }
}
