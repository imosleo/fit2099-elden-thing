package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.FancyMessage;

/**
 * An Action to teleport the actor to another map or location
 * Created by:
 *
 * @author Ian Leong Zheng Yan
 * Modified by:
 */

public class TeleportAction extends Action {
    /**
     * The map of the destination
     */
    private final GameMap destinationString;
    /**
     * The Location that the actor teleported to
     */
    private final Location destination;

    /**
     * Constructor
     *
     * @param destination       the location that the actor teleport to
     * @param destinationString the name of the destination that teleported
     */

    public TeleportAction(Location destination, GameMap destinationString) {
        this.destination = destination;
        this.destinationString = destinationString;
    }

    /**
     * Send the actor to a preset destination
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return The Location that teleported
     */

    @Override
    public String execute(Actor actor, GameMap map) {
        // Check if the destination is occupied by an actor
        if (destination.containsAnActor()) {
            Actor occupant = destination.getActor();
            // Inform the player that teleportation is blocked due to the location being occupied
            return actor + " cannot teleport because the gate is blocked by " + occupant;
        }

        // Proceed with teleportation if destination is not blocked
        map.moveActor(actor, destination);
        FancyMessage.printMessage("" + destinationString);
        return actor + " teleported to " + destinationString;
    }

    /**
     * Returns the descriptive string
     *
     * @param actor The actor performing the action.
     * @return the description that is on the menu
     */

    @Override
    public String menuDescription(Actor actor) {
        return actor + " teleport to " + destinationString;
    }
}
