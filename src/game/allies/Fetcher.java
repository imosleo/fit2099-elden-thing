package game.allies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.behaviours.FetchBehaviour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Represents a Fetcher ally whose goal is to find and collect items on the game map for the player.
 * The Fetcher is designed with low hit points and focuses on moving towards and collecting items,
 * which it then transfers to the player upon retrieval.
 *
 * @author Nicholas Hiew and Nathaniel Chin
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 */
public class Fetcher extends Ally {
    private static final int HP = 1;
    private final Actor player;
    private Location destination;
    private boolean chosen;

    /**
     * Constructor to create a Fetcher ally.
     * Initializes the Fetcher with 1 HP and a specified player for item transfer.
     *
     * @param player The player to whom the Fetcher will transfer collected items.
     */
    public Fetcher(Actor player) {
        super("Fetcher", 'F', HP);
        this.player = player;
        this.destination = null;
        this.chosen = false;
    }

    /**
     * Determines the action to be taken by the Fetcher during its turn.
     * If it hasn't yet chosen a destination, it selects one based on the nearest item found on the map.
     * If the Fetcher has items in its inventory, it transfers them to the player and removes itself from the map.
     *
     * @param actions     List of possible actions for this turn.
     * @param lastAction  The last action performed by the Fetcher.
     * @param map         The current game map.
     * @param display     The display where actions are shown.
     * @return            The selected action for this turn.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        List<Item> items = new ArrayList<>(this.getItemInventory());
        if (!chosen) {
            chosen = true;
            destination = findDestination(map);
            this.behaviours.put(1, new FetchBehaviour(this, destination));
        }
        if (!items.isEmpty()) {
            for (Item item : items) {
                player.addItemToInventory(item);
            }
            this.hurt(HP);
        }
        return super.playTurn(actions, lastAction, map, display);
    }

    /**
     * Scans the map for locations with items and stores these locations and items in a HashMap.
     *
     * @param map The current game map.
     * @return A HashMap with locations as keys and lists of items at each location as values.
     */
    private HashMap<Location, List<Item>> sniffItems(GameMap map) {
        HashMap<Location, List<Item>> items = new HashMap<>();
        for (int x : map.getXRange()) {
            for (int y : map.getYRange()) {
                Location currLocation = map.at(x, y);
                List<Item> itemList = currLocation.getItems();
                if (!itemList.isEmpty()) {
                    items.put(currLocation, itemList);
                }
            }
        }
        return items;
    }

    /**
     * Determines the nearest item location to the Fetcher and sets it as the destination.
     *
     * @param map The current game map.
     * @return The location of the nearest item found on the map.
     */
    private Location findDestination(GameMap map) {
        HashMap<Location, List<Item>> items = sniffItems(map);
        HashMap<Integer, Location> distances = new HashMap<>();
        for (Location location : items.keySet()) {
            int distance = findDistance(map.locationOf(this), location);
            distances.put(distance, location);
        }
        Integer minDistance = Integer.MAX_VALUE;
        for (Integer distance : distances.keySet()) {
            if (distance < minDistance) {
                minDistance = distance;
            }
        }
        return distances.get(minDistance);
    }

    /**
     * Retrieves the current destination location.
     *
     * @return The destination location where the Fetcher is headed.
     */
    public Location getDestination() {
        return destination;
    }

    /**
     * Computes the Manhattan distance between two locations.
     *
     * @param a The first location.
     * @param b The second location.
     * @return The Manhattan distance between location a and location b.
     */
    private static int findDistance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
