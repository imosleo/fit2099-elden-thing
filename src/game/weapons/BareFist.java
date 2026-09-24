package game.weapons;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

/**
 * Class representing a bare fist
 *
 * @author Adrian Kristanto
 * Modified by:
 * @author Nathaniel Chin
 */
public class BareFist extends IntrinsicWeapon {
    /**
     * The amount of damage the weapon deals
     */
    private static final int DAMAGE = 25;
    /**
     * The weapon's hitrate
     */
    private static final int HITRATE = 50;

    /**
     * Constructor
     */
    public BareFist() {
        super(DAMAGE, "punches", HITRATE);
    }

    @Override
    public String toString() {
        return "BareFist";
    }
}
