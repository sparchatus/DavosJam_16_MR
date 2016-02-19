package entities.levels;

import entities.Enemy;
import entities.Level;
import entities.Player;
import main.Main;

public class Level1 extends Level {

    public Level1(){
        Main.player = new Player(Player.WALK_BORDER_LEFT,Main.panel.getHeight()-Player.PLAYER_SIZE);
        enemiesInGame();
    }

    public void enemiesInGame(){
        enemiesToSpawn.add(new Enemy(300, Main.panel.getHeight()-Player.PLAYER_SIZE-TILE_SCREEN_SIZE, 250));
        enemiesToSpawn.add(new Enemy(500, Main.panel.getHeight()-Player.PLAYER_SIZE-TILE_SCREEN_SIZE, 450));
        enemiesToSpawn.add(new Enemy(700, Main.panel.getHeight()-Player.PLAYER_SIZE-TILE_SCREEN_SIZE, 650));
        enemiesToSpawn.add(new Enemy(900, Main.panel.getHeight()-Player.PLAYER_SIZE-TILE_SCREEN_SIZE, 850));
    }
}
