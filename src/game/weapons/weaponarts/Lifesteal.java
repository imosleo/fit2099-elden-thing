package game.weapons.weaponarts;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;

public class Lifesteal implements WeaponArt {
    /**
     * The name of the weaponart
     */
    private final String name = "Lifesteal";
    /**
     * The amount of mana needed for the lifesteal to take effect
     */
    private static final int MANA_REQUIRED = 10;
    /**
     * The health healed when the lifesteal takes effect
     */
    private static final int HEAL = 20;

    /**
     * Heals the player upon a successful attack if they have enough mana
     *
     * @param attacker the owner of the weapon
     * @param target   the actor being targeted by the attack
     * @param map      the map they are on
     * @return a string that represents something that can be displayed to the Player
     */
    @Override
    public String execute(Actor attacker, Actor target, GameMap map) {
        if (attacker.getAttribute(BaseActorAttributes.MANA) >= MANA_REQUIRED) {
            attacker.heal(HEAL);
            attacker.modifyAttribute(BaseActorAttributes.MANA, ActorAttributeOperations.DECREASE, MANA_REQUIRED);
            return String.format("\nAttacking %s heals %s", target, attacker);
        }
        return "";
    }
}
