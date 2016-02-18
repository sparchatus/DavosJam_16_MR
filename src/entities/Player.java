package entities;

public class Player extends Entity{

    private int maxLife;
    private int life;

    public Player(int xCoordinate, int yCoordinate){
        super(xCoordinate,yCoordinate);
        maxLife = 1000;
        life = maxLife;
    }


}
