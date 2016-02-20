package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PictureImport {

    private static String DEF = "default.png";

    public static BufferedImage importImage(String player) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("res/"+player));
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
    public static BufferedImage flip(BufferedImage img){
        BufferedImage _img = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for (int i=0;i<img.getWidth();i++)
            for (int j=0;j<img.getHeight();j++)
            {
                int tmp = img.getRGB(i, j);
                _img.setRGB(i, j, img.getRGB(img.getWidth()-i-1, j));
                _img.setRGB(img.getWidth()-i-1, j, tmp);
            }
        return _img;
    }
}
