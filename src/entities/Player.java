package entities;

import input.Keyboard;
import main.Main;
import util.PictureImport;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{

    private int maxLife;
    private int life;
    private BufferedImage img;
    private final int ATTACK_DURATION = Main.TICKS*2;
    private final int ATTACK_COOLDOWN = Main.TICKS*6;
    private int lastAttackChange=0;
    private boolean attacking = false;

    public Player(int xCoordinate, int yCoordinate){
        super(xCoordinate,yCoordinate);
        maxLife = 1000;
        life = maxLife;
        img= PictureImport.importImage("player.png");
    }

    public void render(Graphics g){
        g.drawImage(img,x,y,null);
    }

    @Override
    public void update() {
        move();
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
    private void move(){
        if(Keyboard.getPressedKeys(65))--x;
        if(Keyboard.getPressedKeys(68))++x;
    }
}
