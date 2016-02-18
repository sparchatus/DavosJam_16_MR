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
    private final int WALK_BORDERS = PLAYER_SIZE*2;
    public static int PLAYER_SIZE=256;
    private int lastAttackChange=0;
    private boolean attacking = false;

    public Player(int xCoordinate, int yCoordinate){
        super(xCoordinate,yCoordinate);
        maxLife = 1000;
        life = maxLife;
        img= PictureImport.importImage("d.png");
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
        if(x+speed>Main.panel.getWidth()-WALK_BORDERS){
            x+=Main.panel.getWidth()-WALK_BORDERS-x;
            Main.level.move((Main.panel.getWidth()-WALK_BORDERS-x)-speed);
        }else if(x+speed<Main.panel.getWidth()-WALK_BORDERS){
            x+=WALK_BORDERS-x;
            Main.level.move((WALK_BORDERS-x)-speed);
        }else{
            x+=speed;
        }
    }
}
