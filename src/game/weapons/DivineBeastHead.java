package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.weapons.DivinePower.Wind;

/**
 * An item that represents the Divine Beast Head
 *
 * @author Nathaniel Chin
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 */
public class DivineBeastHead extends WeaponItem {
    private static final IntrinsicWeapon weapon = new LionBite(new Wind());
    private static final int ZERO = 0;

    /**
     * Constructor
     */
    public DivineBeastHead() {
        super("Divine Beast Head", '$', ZERO, "", ZERO);
    }

    /**
     * Perform the DivineBeastHead attack
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
}
