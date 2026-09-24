package game.spawners;

import game.enemies.Enemy;

/**
 * The Spawner interface defines a contract for spawning enemies.
 * Classes that implement this interface should provide an implementation
 * of the {@code spawnEnemy()} method, which is responsible for generating
 * new enemy instances.
 *
 * This interface promotes flexibility and abstraction in spawning logic,
 * allowing different enemy spawner types to follow a common structure.
 *
 * Created by:
 * @author Nicholas Hiew
 *
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 * @author Nicholas Hiew
 */

public interface Spawner {
    /**
     * Spawns an enemy.
     *
     * @return a new instance of an Enemy if spawned successfully, or {@code null} if not
     */
    Enemy spawnEnemy();
}
