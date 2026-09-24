package game.actors.effects;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.StatusEffect;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.AdditionalActorAttributes;

/**
 * A class representing a temporary stat-changing item.
 * <p>
 * The {@code StatChanger} item increases the player's stats (hitpoints, mana, strength)
 * for a limited number of turns. After the effect wears off, the player's attributes
 * are reduced back to normal. This item is designed to be carried by the player and
 * applies its effect each turn.
 * <p>
 * Created by:
 * @author Nathaniel Chin
 * Modified by: Dylan Matthew Quah Kwang Yung and Nathaniel Chin
 */
public class StatChanger extends StatusEffect {

    /**
     * The amount of hitpoints increased and restored when the effect is active.
     */
    private int hitPoints = 0;

    /**
     * The amount of mana increased and restored when the effect is active.
     */
    private int mana = 0;

    /**
     * The amount of strength increased and restored when the effect is active.
     */
    private int strength = 0;

    /**
     * The number of turns the item can be used before the effect wears off.
     */
    private int charges;

    /**
     * Constructor for creating a {@code StatChanger} with hitpoints, mana, and charges.
     *
     * @param hp      the amount of HP to be reduced when the effect wears off
     * @param mana    the amount of mana to be reduced when the effect wears off
     * @param charges the number of turns before the effect wears off
     */
    public StatChanger(int hp, int mana, int charges) {
        super("StatChanger");
        this.hitPoints = hp;
        this.mana = mana;
        this.charges = charges;
    }

    /**
     * Constructor for creating a {@code StatChanger} with hitpoints and charges.
     *
     * @param hp      the amount of HP to be reduced when the effect wears off
     * @param charges the number of turns before the effect wears off
     */
    public StatChanger(int hp, int charges) {
        super("StatChanger");
        this.hitPoints = hp;
        this.charges = charges;
    }

    /**
     * Constructor for creating a {@code StatChanger} with hitpoints, mana, strength, and charges.
     *
     * @param hp       the amount of HP to be reduced when the effect wears off
     * @param mana     the amount of mana to be reduced when the effect wears off
     * @param strength the amount of strength to be reduced when the effect wears off
     * @param charges  the number of turns before the effect wears off
     */
    public StatChanger(int hp, int mana, int strength, int charges) {
        super("StatChanger");
        this.hitPoints = hp;
        this.mana = mana;
        this.strength = strength;
        this.charges = charges;
    }

    /**
     * Applies the effect each turn, reducing the player's stats back to normal when the effect wears off.
     * <p>
     * Once the number of charges reaches zero, the actor's hitpoints, mana, and strength are
     * decreased by the corresponding amounts, and the item is removed from their inventory.
     *
     * @param currentLocation the location of the actor carrying this item
     * @param actor           the actor carrying this item
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (charges <= 0) {
            actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.DECREASE, hitPoints);
            actor.modifyAttributeMaximum(BaseActorAttributes.MANA, ActorAttributeOperations.DECREASE, mana);
            actor.modifyAttributeMaximum(AdditionalActorAttributes.STRENGTH, ActorAttributeOperations.DECREASE, strength);
            actor.removeStatusEffect(this);
            Display display = new Display();
            display.println("The effect has worn off");
        }
        charges -= 1;
    }
}
