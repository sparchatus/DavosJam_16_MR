package main;

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

}
