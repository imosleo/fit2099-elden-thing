package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.Status;
import game.actors.effects.StunnedEffect;

/**
 * A weapon representing the sting of a jellyfish. When used, it can temporarily stun the target.
 * The JellyfishStinger has no damage and no hit rate but inflicts a stunned effect on the target.
 * Once used, the weapon will also cause the attacker to be removed from the map.
 *
 * @author Nathaniel Chin and Nicholas Hiew
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 *
 */
public class JellyfishStinger extends IntrinsicWeapon {
    private static final int DAMAGE = 0;
    private static final int HITRATE = 0;
    private static final int DURATION = 2;

    /**
     * Constructor to create a JellyfishStinger weapon.
     * Initializes with zero damage and zero hit rate, with the action verb "stings".
     */
    public JellyfishStinger() {
        super(DAMAGE, "stings", HITRATE);
    }

    /**
     * Performs an attack on the target, applying a stun effect if the target is not already stunned.
     * The effect lasts for a specific duration, after which the attacker is removed from the map.
     *
     * @param attacker The actor using the JellyfishStinger.
     * @param target The actor being attacked.
     * @param map The current game map.
     * @return A string describing the attack action.
     */
    @Override
    public String attack(Actor attacker, Actor target, GameMap map) {
        if (!target.hasCapability(Status.STUNNED)) {
            target.addCapability(Status.STUNNED);
            target.addStatusEffect(new StunnedEffect(DURATION));
        }
        map.removeActor(attacker);
        return String.format("%s %s %s", attacker, verb, target);
    }
}
