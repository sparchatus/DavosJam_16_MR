package entities;

import main.Main;
import util.PictureImport;

import java.awt.image.BufferedImage;

public class Prince extends Entity {
    private static final BufferedImage bmp = PictureImport.importImage("Prinz_1.png");
    public Prince(){
        super(0, 0, 200, 200, bmp);
    }

    public void update(){
        x = Main.player.x;
        y = Main.player.y;

    }
}
