package game.weapons;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

/**
 * Represents the intrinsic weapon of the Spirit enemy, known as "Spirit Hand".
 * The {@code SpiritHand} is used by the Spirit to deal damage through a "scratch" attack.
 * It has a base damage of 25 and a hit probability of 50%.
 * 
 * Created by:
 * @author Nicholas Hiew
 *
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 * @author Nathaniel Chin
 */
public class SpiritHand extends IntrinsicWeapon {
    /**
     * Damage dealt by the SpiritHand
     */
    private static final int DAMAGE = 25;
    /**
     * Hitrate of the SpiritHand
     */
    private static final int HITRATE = 50;

    /**
     * Constructor for the SpiritHand weapon.
     * Initializes the weapon with 25 damage, a "scratch" attack, and a 50% hit probability.
     */
    public SpiritHand() {
        super(DAMAGE, "scratch", HITRATE);
    }

    @Override
    public String toString() {
        return "SpiritHand";
    }
}

