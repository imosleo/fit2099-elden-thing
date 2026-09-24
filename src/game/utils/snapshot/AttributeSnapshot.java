package game.utils.snapshot;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import game.actors.AdditionalActorAttributes;

public class AttributeSnapshot implements Snapshot {
    /**
     * Health of actor
     */
    private final int health;

    /**
     * Mana of actor
     */
    private final int mana;

    /**
     * Strength of actor
     */
    private final int strength;

    /**
     * Constructor
     * @param actor
     */
    public AttributeSnapshot(Actor actor) {
        this.health = actor.getAttribute(BaseActorAttributes.HEALTH);
        this.mana = actor.getAttribute(BaseActorAttributes.MANA);
        this.strength = actor.getAttribute(AdditionalActorAttributes.STRENGTH);
    }

    @Override
    public void restore(Actor actor) {
        actor.modifyAttribute(BaseActorAttributes.HEALTH, ActorAttributeOperations.UPDATE, health);
        actor.modifyAttribute(BaseActorAttributes.MANA, ActorAttributeOperations.UPDATE, mana);
        actor.modifyAttribute(AdditionalActorAttributes.STRENGTH, ActorAttributeOperations.UPDATE, strength);
    }
}
