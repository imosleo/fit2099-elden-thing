package game.spawners;

import game.enemies.Enemy;
import game.utils.RandomNumberGenerator;

/**
 * SpiritSpawner is responsible for spawning Spirit enemies based on a
 * predefined chance. If the random number generated is within the spawn
 * chance, a new Spirit enemy is created using the Factory.
 *
 * The spawn chance is set to 20% by default, meaning there is a 20%
 * likelihood that a Spirit will spawn when {@code spawnEnemy()} is called.
 *
 * Created by:
 * @author Nicholas Hiew
 *
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 * @author Nicholas Hiew
 */
public class SpiritSpawner implements Spawner {
    /**
     * Chance to spawn
     */
    private static final int SPAWN_CHANCE = 20;

    /**
     * Initializes the SpiritSpawner with a default spawn chance of 20%.
     */
    public SpiritSpawner() {
    }

    /**
     * Attempts to spawn a Spirit enemy. If the randomly generated number
     * between 0 and 100 is less than or equal to the spawn chance, a new
     * Spirit enemy is created.
     *
     * @return a new Spirit enemy if spawned, or {@code null} if no enemy is spawned
     */
    @Override
    public Enemy spawnEnemy() {
        if (RandomNumberGenerator.randomNumber(0, 100) <= SPAWN_CHANCE) {
            return Factory.createSpirit();
        }
        return null;
    }
}
