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
    private static final int LIFE_BAR_WIDTH = 200;
    private static final int LIFE_BAR_HEIGHT = 30;

    private int lastAttackChange=0;
    private boolean attacking = false;

    public Player(int xCoordinate, int yCoordinate){
        super(xCoordinate,yCoordinate, PLAYER_SIZE, PLAYER_SIZE, PictureImport.importImage("Einhorn_1.png"));
        maxLife = 1000;
        life = maxLife;
        img = PictureImport.importImage("Einhorn_1.png");
        img1 = PictureImport.importImage("Einhorn_2.png");
        _img = PictureImport.importImage("Einhorn_1.png");
        _img1 = PictureImport.importImage("Einhorn_2.png");

        for (int i=0;i<_img.getWidth()/2;i++)
            for (int j=0;j<_img.getHeight();j++)
            {
                int tmp = _img.getRGB(i, j);
                _img.setRGB(i, j, _img.getRGB(_img.getWidth()-i-1, j));
                _img.setRGB(_img.getWidth()-i-1, j, tmp);
            }

        for (int i=0;i<_img1.getWidth()/2;i++)
            for (int j=0;j<_img1.getHeight();j++)
            {
                int tmp = _img1.getRGB(i, j);
                _img1.setRGB(i, j, _img1.getRGB(_img1.getWidth()-i-1, j));
                _img1.setRGB(_img1.getWidth()-i-1, j, tmp);
            }


    }

    public void render(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(x, y + 280, LIFE_BAR_WIDTH, LIFE_BAR_HEIGHT);
        g.setColor(Color.RED);
        g.fillRect(x, y + 280, LIFE_BAR_WIDTH * life / maxLife, LIFE_BAR_HEIGHT);
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
