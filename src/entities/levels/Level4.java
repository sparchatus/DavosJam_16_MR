package entities.levels;

import entities.Enemy;
import entities.Level;
import entities.Player;
import main.Main;

import java.util.ArrayList;

public class Level4 extends Level {

    public Level4() {
        super(5260, "Level_4.png");
        level = 4;
        enemiesInGame();
    }

    public void enemiesInGame(){
        Main.activeEnemies = new ArrayList<>();
        enemiesToSpawn = new ArrayList<>();
        Main.rainbows = new ArrayList<>();
        Main.activeEnemies.add(new Enemy(1000, Main.panel.getHeight()-Enemy.SIZE-TILE_SCREEN_SIZE, 1000- Player.WALK_BORDER_RIGHT));
        Main.activeEnemies.add(new Enemy(1500, Main.panel.getHeight()-Enemy.SIZE-TILE_SCREEN_SIZE, 1500-Player.WALK_BORDER_RIGHT));
        enemiesToSpawn.add(new Enemy(2000, Main.panel.getHeight()-Enemy.SIZE-TILE_SCREEN_SIZE, 2000-Player.WALK_BORDER_RIGHT));
        enemiesToSpawn.add(new Enemy(2500, Main.panel.getHeight()-Enemy.SIZE-TILE_SCREEN_SIZE, 2500-Player.WALK_BORDER_RIGHT));
    }
}