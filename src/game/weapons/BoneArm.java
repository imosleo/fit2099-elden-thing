package game.weapons;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

/**
 * A weapon representing a bone arm that can slash targets.
 * The BoneArm has a specific damage value and hit rate, making it an effective intrinsic weapon.
 *
 * @author Nathianel Chin and Nicholas Hiew
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 */
public class BoneArm extends IntrinsicWeapon {
    private static final int DAMAGE = 10;
    private static final int HITRATE = 50;

    /**
     * Constructor to create a BoneArm weapon.
     * Initializes with a set damage and hit rate, with the action verb "slashes".
     */
    public BoneArm() {
        super(DAMAGE, "slashes", HITRATE);
    }
}
