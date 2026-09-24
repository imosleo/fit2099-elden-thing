package game.consumables;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Interface for consumables.
 *
 * @author Kenzie Rivan Wiguna
 */
public interface Consumable {

    /**
     * This method is used to define how the consumables affect the actor.
     * For example, some consumables may only restore an actor's health
     * while other, it may increase the maximum capacity of an actor's health.
     *
     * @param actor the actor who is consuming
     * @return the description of what the weapon did when the attack was performed
     */
    String consume(Actor actor);

    default String consume(Actor actor, GameMap map) {
        return consume(actor);
    }
}
