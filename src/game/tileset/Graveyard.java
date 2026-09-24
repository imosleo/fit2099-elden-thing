package game.tileset;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.Enemy;
import game.spawners.Spawner;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;

/**
 * Graveyard is a type of {@code Ground} that periodically spawns enemies
 * using a provided {@code Spawner}. When an enemy is spawned, it attempts
 * to find an adjacent, unoccupied tile that the enemy can enter and spawns
 * the enemy there.
 * <p>
 * The {@code tick()} method is responsible for handling the enemy spawning
 * logic on each game tick. If an enemy is successfully spawned, it will be
 * placed on one of the valid adjacent locations.
 *
 * @author Nicholas Hiew
 * Modified by: Dylan Matthew Quah Kwang Yung and Nicholas Hiew
 */
public class Graveyard extends Ground {
    private final Spawner spawner;

    /**
     * Initializes the Graveyard with a spawner for enemy generation.
     *
     * @param spawn the Spawner responsible for generating enemies
     */
    public Graveyard(Spawner spawn) {
        super('n', "Graveyard");
        this.spawner = spawn;
    }

    /**
     * Called every tick (turn) to check if an enemy should be spawned.
     * If an enemy is spawned, it will be placed on a valid adjacent tile
     * that can accommodate the enemy.
     *
     * @param location the current location of the Graveyard in the game
     */
    @Override
    public void tick(Location location) {
        Enemy enemy = spawner.spawnEnemy();
        if (enemy != null) {
            ArrayList<Location> adjacentTiles = new ArrayList<>();
            for (Exit exit : location.getExits()) {
                if (exit.getDestination().getGround().canActorEnter(enemy) && !exit.getDestination().containsAnActor()) {
                    adjacentTiles.add(exit.getDestination());
                }
            }
            if (!adjacentTiles.isEmpty()) {
                int randIndex = RandomNumberGenerator.randomIndex(adjacentTiles.size());
                Location spawnTile = adjacentTiles.get(randIndex);
                spawnTile.addActor(enemy);
            }
        }
    }
}
