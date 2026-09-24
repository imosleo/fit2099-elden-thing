package game.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.action.SpawnAction;
import game.allies.Ally;
import game.allies.Fetcher;
import game.allies.SkeletonSoldier;
import game.allies.StunningJellyfish;

/**
 * An item representing the Staff of Spawning. This staff allows the player to spawn various ally types,
 * including Fetcher, SkeletonSoldier, and StunningJellyfish.
 *
 * @author Nicholas Hiew and Nathaniel Chin
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 */
public class SpawnerStaff extends Item {
    private Ally ally;

    /**
     * Constructor to create a SpawnerStaff.
     * Initializes the item with the name "Staff of Spawning" and a unique display character.
     * The staff is portable.
     */
    public SpawnerStaff() {
        super("Staff of Spawning", '¥', true);
    }

    /**
     * Determines the actions available when this item is in possession of an actor.
     * Allows the actor to spawn specific allies (Fetcher, SkeletonSoldier, StunningJellyfish)
     * using SpawnAction for each ally type.
     *
     * @param owner The actor holding the SpawnerStaff.
     * @return A list of allowable actions for this item.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new SpawnAction(new Fetcher(owner), owner));
        actions.add(new SpawnAction(new SkeletonSoldier(owner), owner));
        actions.add(new SpawnAction(new StunningJellyfish(owner), owner));
        return actions;
    }
}
