package entities;

import util.PictureImport;

public class Rainbow extends Entity{
    public Rainbow(int x, int y){
        super(x, y, 40, 40, PictureImport.importImage("Rainbow.png"));
    }
}
