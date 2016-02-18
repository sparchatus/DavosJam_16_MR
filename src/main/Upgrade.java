package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Upgrade {
    public final String NAME;
    public int level;
    public int cost;
    public final BufferedImage ICON;
    public static final float costMultiplier = 1.5f;
    public int x;
    public static int y;
    public static int size;

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

    public Graphics render(Graphics g){


        g.setColor(Color.BLACK);
        g.fillRect(x, y, size, size);
        g.setFont(new Font("Calibri", 0, 24));
        g.drawString(NAME + '(' + cost + "$)", (int)(x + 1.5f * size), y + (size + g.getFont().getSize()) / 2);

        return g;
    }

}
