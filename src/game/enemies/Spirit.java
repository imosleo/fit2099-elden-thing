package game.enemies;

import game.actors.Ability;
import game.behaviours.AttackBehaviour;
import game.behaviours.WanderBehaviour;
import game.weapons.SpiritHand;

/**
 * Represents a Spirit enemy in the game.
 * <p>
 * The {@code Spirit} enemy has two main behaviours: wandering around the map and attacking other actors.
 * It uses the {@code SpiritHand} as its intrinsic weapon, representing a spiritual attack.
 *
 * @author Nicholas Hiew
 * Modified by: Dylan Matthew Quah Kwang Yung and Nicholas Hiew
 */
public class Spirit extends Enemy {
    /**
     * HP of the Spirit
     */
    private static final int HP = 100;
    /**
     * Constructor for the Spirit.
     * <p>
     * Initializes the Spirit with 100 hit points and assigns it two behaviours: wandering and attacking.
     * The Spirit also uses the {@code SpiritHand} as its intrinsic weapon.
     */
    public Spirit() {
        super("Spirit", '&', HP);
        this.behaviours.put(3, new WanderBehaviour());
        this.behaviours.put(1, new AttackBehaviour());
        this.setIntrinsicWeapon(new SpiritHand());
        this.addCapability(Ability.CANNOT_ENTER_FLOOR);
    }
}
