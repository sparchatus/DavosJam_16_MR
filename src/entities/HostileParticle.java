package entities;

import com.sun.javafx.geom.Vec2f;
import util.PictureImport;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HostileParticle extends Entity{
    private static final BufferedImage BITMAP = PictureImport.importImage("default.png");
    private Vec2f speed;

    public HostileParticle(int x, int y, Vec2f speed){
        super(x, y);
        this.speed = speed;
    }

    public void render(Graphics g){
        g.drawImage(BITMAP, x, y, 50, 50, null);
    }
}
