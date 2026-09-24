package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

/**
 * An item representing the Furnace Engine
 *
 * @author Nathaniel Chin
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 */
public class FurnaceEngine extends WeaponItem {
    private static final int HEAL = 30;
    private static final IntrinsicWeapon weapon = new GolemStomp();
    private static final int ZERO = 0;

    /**
     * Constructor
     */
    public FurnaceEngine() {
        super("Furnace Engine", 'E', ZERO, "", ZERO);
    }

    /**
     * Perform the Golem Stomp attack
     *
     * @param attacker the actor who performed the attack
     * @param target   the actor who is the target of the attack
     * @param map      the map on which the attack was executed
     * @return the description of what the weapon did when the attack was performed
     */
    @Override
    public String attack(Actor attacker, Actor target, GameMap map) {
        return weapon.attack(attacker, target, map);
    }

    /**
     * Heals the actor on every turn after the Player has traded this
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor           The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        actor.heal(HEAL);
    }
}
