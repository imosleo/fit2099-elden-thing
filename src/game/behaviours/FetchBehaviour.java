package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;

/**
 * Represents a behaviour that directs an actor to fetch an item at a specified destination.
 * The {@code FetchBehaviour} guides the actor towards the target location and picks up items
 * found along the way or at the destination.
 *
 * This behaviour supports movement towards a goal and item pickup, creating a series of
 * {@code MoveActorAction} and {@code PickUpAction} actions to achieve the objective.
 *
 * @author Nicholas Hiew and Nathaniel Chin
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 */
public class FetchBehaviour implements Behaviour {
    private final Actor owner;
    private final Location destination;

    /**
     * Constructor to initialize a FetchBehaviour for a specified destination.
     *
     * @param subject     The actor who owns this behaviour.
     * @param destination The target location where the actor should move and fetch items.
     */
    public FetchBehaviour(Actor subject, Location destination) {
        this.owner = subject;
        this.destination = destination;
    }

    /**
     * Determines the next action for the actor to take based on the fetch objective.
     * If the actor is not at the destination, the actor moves towards it. If the actor is at
     * the destination and items are present, the actor will attempt to pick up the items.
     *
     * @param actor The actor executing this behaviour.
     * @param map   The current game map.
     * @return      A {@code MoveActorAction} to move closer to the destination or a {@code PickUpAction}
     *              to pick up an item, or {@code null} if no further actions are needed.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        List<Item> items = map.locationOf(actor).getItems();

        // If the actor is not at the destination, move towards it
        if (map.locationOf(owner) != destination) {
            int currentDistance = distance(map.locationOf(owner), destination);
            for (Exit exit : map.locationOf(owner).getExits()) {
                Location destination = exit.getDestination();
                if (destination.canActorEnter(actor)) {
                    int newDistance = distance(destination, this.destination);
                    if (newDistance < currentDistance) {
                        return new MoveActorAction(destination, exit.getName());
                    }
                }
            }
        }

        // If items are at the current location, pick them up
        if (!items.isEmpty()) {
            for (Item item : items) {
                return new PickUpAction(item);
            }
        }
        return null;
    }

    /**
     * Calculates the Manhattan distance between two locations.
     *
     * @param a The starting location.
     * @param b The target location.
     * @return  The distance in terms of grid steps between the two locations.
     */
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
