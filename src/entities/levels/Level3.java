package entities.levels;

import entities.Enemy;
import entities.Level;
import entities.Player;
import main.Main;

import java.util.ArrayList;

public class Level3 extends Level {

    public Level3() {
        super(5260, "Level_3.png");
        level = 3;
        enemiesInGame();
    }

    public void enemiesInGame(){
        Main.activeEnemies = new ArrayList<>();
        enemiesToSpawn = new ArrayList<>();
        Main.rainbows = new ArrayList<>();
        Main.activeEnemies.add(new Enemy(1000, 1000- Player.WALK_BORDER_RIGHT));
        Main.activeEnemies.add(new Enemy(1500, 1500-Player.WALK_BORDER_RIGHT));
        enemiesToSpawn.add(new Enemy(2000, 2000-Player.WALK_BORDER_RIGHT));
        enemiesToSpawn.add(new Enemy(2500, 2500-Player.WALK_BORDER_RIGHT));
    }
}
