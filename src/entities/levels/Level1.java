package entities.levels;

import entities.Enemy;
import entities.Level;
import entities.Player;
import main.Main;

public class Level1 extends Level {

    public Level1(){
        super(4000, "Level_1.png");
        Main.player = new Player(Player.WALK_BORDER_LEFT,Main.panel.getHeight()-Player.PLAYER_SIZE-TILE_SCREEN_SIZE);
        enemiesInGame();
    }

    public void enemiesInGame(){
        enemiesToSpawn.add(new Enemy(600, Main.panel.getHeight()-Player.PLAYER_SIZE-TILE_SCREEN_SIZE, 250));
        enemiesToSpawn.add(new Enemy(1000, Main.panel.getHeight()-Player.PLAYER_SIZE-TILE_SCREEN_SIZE, 450));
        enemiesToSpawn.add(new Enemy(1400, Main.panel.getHeight()-Player.PLAYER_SIZE-TILE_SCREEN_SIZE, 650));
        enemiesToSpawn.add(new Enemy(1800, Main.panel.getHeight()-Player.PLAYER_SIZE-TILE_SCREEN_SIZE, 850));
    }
}
