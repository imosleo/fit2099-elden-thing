package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.Ability;
import game.actors.effects.PoisonEffect;

import java.util.Random;

/**
 * ManFlySting represents a weapon used by the Man Fly for a sting attack.
 * This weapon has a chance to deal damage, poison the target, and apply poison effects over time.
 * <p>
 * The sting attack has a 25% chance to hit, and if it hits, there's a 30% chance to poison the target
 * (unless the target is immune to poison).
 * <p>
 * The poison effect is processed immediately after being applied, causing additional damage in subsequent ticks.
 *
 * @author Nicholas Hiew
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 * @author Nathaniel Chin
 */
public class ManFlySting extends IntrinsicWeapon {
    /**
     * Damage dealt by the sting
     */
    private static final int DAMAGE = 20;
    /**
     * Hitrate of the sting
     */
    private static final int HITRATE = 25;

    // Constants representing the chance to apply poison and hit the target
    /**
     * Chance to poison
     */
    private static final int POISON_CHANCE = 30;
    /**
     * How long the poison lasts
     */
    private static final int POISON_AGE = 2;
    /**
     * How much damage the poison performs
     */
    private static final int POISON_DMG = 10;

    /**
     * Constructor for the ManFlySting.
     */
    public ManFlySting() {
        super(DAMAGE, "sting", HITRATE);  // Initialize with 20 damage, weapon name "sting", and hit chance of 25
    }

    /**
     * Executes the sting attack on the target actor.
     * The attack has a chance to hit, and if successful, may apply poison.
     *
     * @param attacker The actor performing the sting attack.
     * @param target   The actor being attacked.
     * @param map      The map where the attack takes place.
     * @return A description of the interaction between the attacker and the target.
     */
    @Override
    public String attack(Actor attacker, Actor target, GameMap map) {
        Random rand = new Random();
        String interactionResult = super.attack(attacker, target, map);  // Base interaction result

        // Determine if the attack hits based on the HITRATE
        if (rand.nextInt(100) < HITRATE) {

            // Check if the target is immune to poison
            if (!target.hasCapability(Ability.POISON_RES)) {
                // Roll to check if poison is applied
                int poisonRoll = rand.nextInt(100);

                if (poisonRoll < POISON_CHANCE) {
                    interactionResult += "\n" + target + " is poisoned!";
                    target.addStatusEffect(new PoisonEffect(POISON_AGE,POISON_DMG));  // Apply poison effect to the target

                } else {
                    interactionResult += "\n" + target + " resisted the poison.";
                }
            } else {
                interactionResult += "\n" + target + " is immune to poison.";
            }

            // Apply the damage from the sting attack
            target.hurt(this.damage);
        } else {
            interactionResult += "\n" + attacker + " missed the sting.";  // If the attack misses
        }

        return interactionResult;  // Return the result of the interaction
    }

    @Override
    public String toString() {
        return "ManFlySting";
    }
}
