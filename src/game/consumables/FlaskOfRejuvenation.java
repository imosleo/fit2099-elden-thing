package game.consumables;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.action.ConsumeAction;

/**
 * Class representing a flask of rejuvenation
 *
 * @author Kenzie Rivan Wiguna
 */
public class FlaskOfRejuvenation extends Item implements Consumable {

    /**
     * Amount of mana restored
     */
    private static final int MANA_RESTORED = 100;
    /**
     * Amount of times can be used
     */
    private static final int MAX_CHARGES = 3;
    /**
     * Number of times has been used
     */
    private int charges;

    public FlaskOfRejuvenation() {
        super("Flask of Rejuvenation", 'o', true);
        this.charges = 0;
    }

    @Override
    public String consume(Actor actor) {
        if (charges < MAX_CHARGES) {
            actor.modifyAttribute(BaseActorAttributes.MANA, ActorAttributeOperations.INCREASE, MANA_RESTORED);
            charges++;
            return String.format("%s consumed by %s. %s feels rejuvenated", this, actor, actor);
        }
        return String.format("%s is empty", this);
    }

    @Override
    public ActionList allowableActions(Actor otherActor) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(otherActor, this));
        return actions;
    }
}