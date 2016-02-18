package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Upgrade {
    public final String NAME;
    public int level;
    public int cost;
    public final BufferedImage ICON;
    public static final float costMultiplier = 1.5f;

    public Upgrade(String name, BufferedImage icon, int initialCost){
        NAME = name;
        ICON = icon;
        level = 1;
        cost = initialCost;
    }

    public void buy(){
        Main.money -= cost;
        ++level;
        cost *= costMultiplier;
    }

    public Graphics render(Graphics g, int x, int y, int size){
        System.out.println(size);
        g.setColor(Color.BLACK);
        g.fillRect(x, y, size, size);

        return g;
    }

}
