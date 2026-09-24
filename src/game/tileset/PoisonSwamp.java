package game.tileset;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Ability;
import game.actors.effects.PoisonEffect;

/**
 * Represents a poisonous swamp in the game world.
 *
 * The {@code PoisonSwamp} inflicts poison damage on any actor standing on it,
 * unless the actor has poison resistance. The poison lasts for a specified
 * duration and deals damage over time.
 *
 * Created by:
 * @author Ian Leong Zheng Yan
 *
 * Modified by:
 * @author Ian Leong Zheng Yan
 * @author Dylan Matthew Quah Kwang Yung
 *
 */
public class PoisonSwamp extends Ground {

    /**
     * The duration for which the poison effect lasts (in turns).
     */
    private static final int POISON_DURATION = 3;

    /**
     * The amount of damage the poison inflicts each turn.
     */
    private static final int POISON_DAMAGE = 5;

    /**
     * Constructor for the PoisonSwamp.
     *
     * Initializes the {@code PoisonSwamp} with the specified display character and name.
     *
     */
    public PoisonSwamp() {
        super('+', "Poison Swamp");
    }

    /**
     * Inflicts poison on actors that step on the poison swamp if they are not immune.
     *
     * The poison lasts for {@code age} turns and deals {@code damage} each turn,
     * applied via the {@code PoisonEffect}. Actors with the {@code POISON_RES} ability
     * are immune to this effect.
     *
     * @param location the location of the PoisonSwamp
     */
    @Override
    public void tick(Location location) {
        Actor actor = location.getActor();
        if (location.containsAnActor() && !actor.hasCapability(Ability.POISON_RES)) {
            actor.addStatusEffect(new PoisonEffect(POISON_DURATION, POISON_DAMAGE));
        }
    }
}
