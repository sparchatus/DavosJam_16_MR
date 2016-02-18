package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PictureImport {

    private static String DEF = "res/default.png";

    public static BufferedImage importImage(String player) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(player));
        } catch (IOException e) {
            //e.printStackTrace();
            if(!player.equals(DEF)) {
                img = importImage(DEF);
            }else{
                return null;
            }
        }
        return img;
    }
}
