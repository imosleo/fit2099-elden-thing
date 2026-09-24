package game.spawners;

import game.enemies.Enemy;
import game.utils.RandomNumberGenerator;

/**
 * ManFlySpawner is responsible for spawning ManFly enemies based on a
 * predefined chance. If the random number generated is within the spawn
 * chance, a new ManFly enemy is created using the Factory.
 *
 * The spawn chance is set to 15% by default, meaning there is a 15%
 * likelihood that a ManFly will spawn.
 *
 * Created by:
 * @author Nicholas Hiew
 *
 * Modified by:
 * @author Nicholas Hiew
 * @author Dylan Matthew Quah Kwang Yung
 */
public class ManFlySpawner implements Spawner {
    /**
     * Chance to spawn
     */
    private static final int SPAWN_CHANCE = 15;

    /**
     * Initializes the ManFlySpawner
     */
    public ManFlySpawner() {
    }

    /**
     * Attempts to spawn a ManFly enemy. If the randomly generated number
     * between 0 and 100 is less than or equal to the spawn chance, a new
     * ManFly enemy is created.
     *
     * @return a new ManFly enemy if spawned, or {@code null} if no enemy is spawned
     */
    @Override
    public Enemy spawnEnemy() {
        if (RandomNumberGenerator.randomNumber(0, 100) <= SPAWN_CHANCE) {
            return Factory.createManFly();
        }
        return null;
    }
}
