package entities;

import com.sun.javafx.geom.Vec2f;
import util.PictureImport;

public class HostileParticle extends Entity{
    private Vec2f speed;
    private static int SIZE = 50;

    public HostileParticle(int x, int y, Vec2f speed){
        super(x, y, SIZE, SIZE,PictureImport.importImage("default.png"));
        this.speed = speed;
    }
}
