package game.weapons.DivinePower;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.tileset.GroundType;

import java.util.ArrayList;
import java.util.List;

public class Frost implements DivinePower {
    @Override
    public String execute(Actor attacker, Actor target, GameMap map) {
        // Get the target's current location and ground
        Location targetLocation = map.locationOf(target);
        Ground ground = targetLocation.getGround();

        if (ground.hasCapability(GroundType.WATER)) {
            // Get the inventory of the target (actor)
            List<Item> inventory = target.getItemInventory();

            // Make a copy of the inventory list and iterate over the copy
            if (!inventory.isEmpty()) {
                List<Item> inventoryCopy = new ArrayList<>(inventory);
                for (Item item : inventoryCopy) {
                    target.removeItemFromInventory(item);  // Safely remove the item from the original inventory
                    targetLocation.addItem(item);  // Drop item on the ground
                }
                return String.format("Frost divine power causes %s to drop all items!", target);
            } else {
                return String.format("Frost divine power has no effect, %s has no items to drop", target);
            }
        }
        return String.format("Frost divine power has no effect, %s is not on water", target);
    }


    @Override
    public DivinePower nextPower() {
        return new Wind();
    }
}
