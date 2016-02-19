package entities;

import main.Main;
import util.PictureImport;

import java.awt.image.BufferedImage;

public class Prince extends Entity {
    private static final BufferedImage bmp = PictureImport.importImage("Prinz_1.png");
    private static final BufferedImage _img = PictureImport.importImage("Prinz_1.png");

    public Prince(){
        super(0, 0, 200, 200, bmp);
        for (int i=0;i<_img.getWidth()/2;i++)
            for (int j=0;j<_img.getHeight();j++)
            {
                int tmp = _img.getRGB(i, j);
                _img.setRGB(i, j, _img.getRGB(_img.getWidth()-i-1, j));
                _img.setRGB(_img.getWidth()-i-1, j, tmp);
            }
    }

    public void update(){
        if(Main.player.speed > 0){
            bi = bmp;
            x = Main.player.x;
            y = Main.player.y;
        }
        else{
            bi = _img;
            x = Main.player.x + 55;
            y = Main.player.y;
        }

    }
}
