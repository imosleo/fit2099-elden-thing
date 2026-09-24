package game.tileset;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.action.ConsumeAction;
import game.consumables.Consumable;
import game.enemies.Enemy;
import game.spawners.ScarabSpawner;
import game.spawners.Spawner;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;

/**
 * A class that represents a random puddle of water.
 * <p>
 * The {@code Puddle} is consumable by actors, providing a small mana boost.
 * Additionally, when consumed, there is a chance to spawn a Scarab enemy in
 * the surrounding tiles of the actor.
 *
 * Created by:
 * @author Adrian Kristanto
 *
 * Modified by:
 * @author Nathaniel Chin
 * @author Dylan Matthew Quah Kwang Yung
 */
public class Puddle extends Ground implements Consumable {

    /**
     * Amount of mana restored upon consumption.
     */
    private static final int MANA_RESTORED = 5;

    /**
     * Spawner for generating Scarab enemies.
     */
    private final Spawner spawner;

    /**
     * Constructor for the Puddle, setting its display character and name.
     * Also initializes a {@code ScarabSpawner}.
     */
    public Puddle() {
        super('~', "Puddle");
        this.addCapability(GroundType.NON_BURNABLE);
        this.addCapability(GroundType.WATER);
        this.spawner = new ScarabSpawner();
    }

    /**
     * Increases the actor's mana upon consuming the puddle.
     *
     * @param actor the actor consuming the puddle
     * @return a description of the consumption event
     */
    public String consume(Actor actor) {
        actor.modifyAttribute(BaseActorAttributes.MANA, ActorAttributeOperations.INCREASE, MANA_RESTORED);
        return String.format("%s consumed by %s.", this, actor);
    }

    /**
     * Consumes the puddle and attempts to spawn a Scarab in the surrounding area.
     *
     * @param actor the actor consuming the puddle
     * @param map   the map where the actor is located
     * @return a description of the consumption and potential Scarab spawn
     */
    @Override
    public String consume(Actor actor, GameMap map) {
        String retval = this.consume(actor);
        Enemy enemy = spawner.spawnEnemy();
        if (enemy != null) {
            ArrayList<Location> adjacentTiles = new ArrayList<>();
            for (Exit exit : map.locationOf(actor).getExits()) {
                if (exit.getDestination().getGround().canActorEnter(enemy) && !exit.getDestination().containsAnActor()) {
                    adjacentTiles.add(exit.getDestination());
                }
            }
            if (!adjacentTiles.isEmpty()) {
                int randIndex = RandomNumberGenerator.randomIndex(adjacentTiles.size());
                Location spawnTile = adjacentTiles.get(randIndex);
                spawnTile.addActor(enemy);
                retval += String.format("%nA scarab has spawned in the vicinity");
            }
        }
        return retval;
    }

    /**
     * Returns a list of actions that the actor can perform on the puddle.
     * If the actor is standing on the puddle, they can consume it.
     *
     * @param actor     the actor interacting with the puddle
     * @param location  the location of the puddle
     * @param direction the direction from the actor to the puddle
     * @return a list of allowable actions, including consuming the puddle
     */
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (location.getActor() == actor) actions.add(new ConsumeAction(actor, this));
        return actions;
    }

}
