package entities.levels;

import entities.Enemy;
import entities.Level;
import entities.Player;
import main.Main;

public class Level1 extends Level {

    public Level1(){
        super(3000, "Level_1.png");
        Main.player = new Player(Player.WALK_BORDER_LEFT,Main.panel.getHeight()-Player.PLAYER_SIZE-TILE_SCREEN_SIZE);
        enemiesInGame();
    }

    public void enemiesInGame(){
        Main.activeEnemies.add(new Enemy(1000, Main.panel.getHeight()-Enemy.SIZE-TILE_SCREEN_SIZE, 1000-Player.WALK_BORDER_RIGHT));
        Main.activeEnemies.add(new Enemy(1500, Main.panel.getHeight()-Enemy.SIZE-TILE_SCREEN_SIZE, 1500-Player.WALK_BORDER_RIGHT));
        enemiesToSpawn.add(new Enemy(2000, Main.panel.getHeight()-Enemy.SIZE-TILE_SCREEN_SIZE, 2000-Player.WALK_BORDER_RIGHT));
        enemiesToSpawn.add(new Enemy(2500, Main.panel.getHeight()-Enemy.SIZE-TILE_SCREEN_SIZE, 2500-Player.WALK_BORDER_RIGHT));
    }
}
