package game.actors.effects;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.StatusEffect;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Represents a poison effect that damages an actor for a limited number of turns.
 * This class extends StatusEffect to provide functionality for applying damage to an actor over time.
 * The poison effect damages an actor by a fixed amount each turn, reducing in effectiveness after a certain number of turns.
 *
 * @author Ian Leong Zheng Yan
 * Modified by:
 */
public class PoisonEffect extends StatusEffect {

    /**
     * The remaining number of turns the poison effect is active.
     */
    private int age;

    /**
     * The damage dealt to the actor each turn.
     */
    private final int damage;

    /**
     * Constructor to create a poison effect.
     * Initializes the poison effect with a set duration and damage amount.
     */
    public PoisonEffect(int age, int damage) {
        super("Poison Effect");
        this.age = age; // Poison effect lasts for 3 turns
        this.damage = damage; // Deals 5 damage each turn
    }

    /**
     * Performs the poison effect on the specified actor each turn.
     * If the poison effect has remaining turns, it deals damage to the actor.
     * Once the poison effect duration ends, it is removed from the actor.
     *
     * @param location the location of the actor affected by the poison
     * @param actor    the actor affected by the poison effect
     */
    @Override
    public void tick(Location location, Actor actor) {
        if (age > 0) {
            actor.hurt(damage);
            new Display().println(String.format("%s is poisoned", actor));
            age--;
        } else {
            actor.removeStatusEffect(this);
        }
    }
}
