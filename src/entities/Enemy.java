package entities;

import util.PictureImport;

public class Enemy extends Entity{

    public Enemy(int xCoordinate, int yCoordinate) {
        super(xCoordinate, yCoordinate, Player.PLAYER_SIZE,Player.PLAYER_SIZE, PictureImport.importImage("Enemy_1.png"));
    }
}
