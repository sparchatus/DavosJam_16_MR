package entities.levels;

import entities.Enemy;
import entities.Level;
import entities.Player;
import main.Main;

public class Level2 extends Level {
    public Level2() {
        super(5780, "Level_2.png");
        level = 2;
        enemiesInGame();
    }

    public void enemiesInGame(){
        Main.activeEnemies.add(new Enemy(1000, 1000- Player.WALK_BORDER_RIGHT));
        Main.activeEnemies.add(new Enemy(1500, 1500-Player.WALK_BORDER_RIGHT));
        enemiesToSpawn.add(new Enemy(2000, 2000-Player.WALK_BORDER_RIGHT));
        enemiesToSpawn.add(new Enemy(2500, 2500-Player.WALK_BORDER_RIGHT));
    }
}
