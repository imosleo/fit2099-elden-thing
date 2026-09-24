package game.tileset;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.action.TeleportAction;

import java.util.ArrayList;

/**
 * Represents a gate that allows teleportation to other maps in the game.
 * This class extends Ground and provides functionality to add teleport destinations and
 * perform teleportation for actors interacting with the gate.
 *
 * @author Ian Leong Zheng Yan
 * @see Ground
 * Modified by:
 */
public class Gate extends Ground {

    /**
     * A list of maps that this gate can teleport to.
     */
    private ArrayList<GameMap> maps = new ArrayList<>();

    /**
     * A list of destination locations on the corresponding maps.
     */
    private ArrayList<Location> gatelocation = new ArrayList<>();

    /**
     * Constructor to create a gate.
     */
    public Gate() {
        super('H', "Gate");
    }

    /**
     * Adds a teleport destination for this gate.
     *
     * @param map         the target map where the gate can teleport to
     * @param destination the specific location in the target map where the teleport will land
     */
    public void addDestination(GameMap map, Location destination) {
        maps.add(map);
        gatelocation.add(destination);
    }

    /**
     * Returns the list of actions allowed when an actor interacts with this gate.
     * If the actor is not on the map corresponding to the destination, a teleport action is added to the list.
     *
     * @param actor     the actor interacting with the gate
     * @param location  the current location of the actor
     * @param direction the direction of the gate relative to the actor
     * @return an ActionList containing the allowable actions
     * @see ActionList
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (maps.isEmpty()) {
            return actions;
        }

        for (int i = 0; i < maps.size(); i++) {
            if (!maps.get(i).contains(actor)) {
                Location gateLocation = gatelocation.get(i);
                actions.add(new TeleportAction(gateLocation, maps.get(i)));
            }
        }

        return actions;
    }
}
