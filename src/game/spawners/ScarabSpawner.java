package game.spawners;

import game.enemies.Enemy;
import game.utils.RandomNumberGenerator;

/**
 * ScarabSpawner is responsible for spawning Scarab enemies based on a
 * predefined chance. If the random number generated is within the spawn
 * chance, a new Scarab enemy is created using the Factory.
 * <p>
 * The spawn chance is set to 10% by default, meaning there is a 10%
 * likelihood that a Scarab will spawn.
 * <p>
 * Created by:
 *
 * @author Nicholas Hiew
 * <p>
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 * @author Nicholas Hiew
 */
public class ScarabSpawner implements Spawner {
    /**
     * Chance to spawn
     */
    private static final int SPAWN_CHANCE = 10;

    /**
     * Initializes the ScarabSpawner
     */
    public ScarabSpawner() {
    }

    /**
     * Attempts to spawn a Scarab enemy. If the randomly generated number
     * between 0 and 100 is less than or equal to the spawn chance, a new
     * Scarab enemy is created.
     *
     * @return a new Scarab enemy if spawned, or {@code null} if no enemy is spawned
     */
    @Override
    public Enemy spawnEnemy() {
        if (RandomNumberGenerator.randomNumber(0, 100) <= SPAWN_CHANCE) {
            return Factory.createScarab();
        }
        return null;
    }
}
