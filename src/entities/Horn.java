package entities;

import main.Main;
import util.PictureImport;

import java.awt.image.BufferedImage;

public class Horn  extends Entity{

    public static final BufferedImage horn1 = PictureImport.importImage("Horn_standard.png");
    public static final BufferedImage horn2 = PictureImport.importImage("Horn_red.png");
    public static final BufferedImage horn3 = PictureImport.importImage("Horn_gold.png");
    public static final BufferedImage horn4 = PictureImport.importImage("Horn_rainbow.png");

    public static final BufferedImage _horn1 = PictureImport.importImage("Horn_standard_attack.png");
    public static final BufferedImage _horn2 = PictureImport.importImage("Horn_red_attack.png");
    public static final BufferedImage _horn3 = PictureImport.importImage("Horn_gold_attack.png");
    public static final BufferedImage _horn4 = PictureImport.importImage("Horn_rainbow_attack.png");

    public static int h = 1;
    public static BufferedImage horn = horn1;
    private static BufferedImage _horn = PictureImport.flip(horn);
    public static BufferedImage attackHorn = horn1;
    private static BufferedImage _attackHorn = PictureImport.flip(_horn3);

    public Horn(){
        super(0, 0, 32, 32, horn);
    }

    public void update() {
        if (!Main.player.attacking) {
            if (Main.player.speed > 0) {
                bi = horn;
                x = Main.player.x + 200;
                y = Main.player.y + 60;
            } else {
                bi = _horn;
                x = Main.player.x + 20;
                y = Main.player.y + 60;
            }
        } else{
            if(Main.player.speed > 0){
                bi = attackHorn;
                x = Main.player.x + 240;
                y = Main.player.y + 130;
            } else{
                bi = _attackHorn;
                x = Main.player.x - 20;
                y = Main.player.y + 130;
            }

        }
    }
}
