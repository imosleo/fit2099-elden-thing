package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import game.actors.AdditionalActorAttributes;

/**
 * Class representing a short sword
 *
 * @author Kenzie Rivan Wiguna
 */
public class ShortSword extends WeaponItem {
    /**
     * The amount of damage the weapon deals
     */
    private static final int DAMAGE = 100;
    /**
     * The weapon's hitrate
     */
    private static final int HITRATE = 75;
    /**
     * Strength requirement
     */
    private static final int STRENGTH_REQ = 10;

    /**
     * Constructor.
     */
    public ShortSword() {
        super("Short Sword", '!', DAMAGE, "slashes", HITRATE);
    }

    /**
     * Create and return an action to pick this Item up.
     * If the player doesn't have the requisite strength then return null
     *
     * @return a new PickUpItemAction if this Item is portable and if they have the requisite strength, null otherwise.
     */
    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        if (actor.hasAttribute(AdditionalActorAttributes.STRENGTH) && actor.getAttribute(AdditionalActorAttributes.STRENGTH) >= STRENGTH_REQ) {
            return super.getPickUpAction(actor);
        }
        return null;
    }
}
