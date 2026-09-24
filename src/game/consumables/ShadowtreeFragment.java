package game.consumables;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.action.ConsumeAction;
import game.actors.AdditionalActorAttributes;

/**
 * Class representing a shadowtree fragment
 *
 * @author Kenzie Rivan Wiguna
 */
public class ShadowtreeFragment extends Item implements Consumable {

    /**
     * Amount of hitpoints increased and restored
     */
    private static final int HP = 50;

    /**
     * Amount of mana increased and restored
     */
    private static final int MANA = 25;

    /**
     * Amount of strength increased
     */
    private static final int STRENGTH = 5;

    /**
     * Constructor
     */
    public ShadowtreeFragment() {
        super("Shadowtree Fragment", 'e', true);
    }

    @Override
    public String consume(Actor actor) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, HP);
        actor.modifyAttributeMaximum(BaseActorAttributes.MANA, ActorAttributeOperations.INCREASE, MANA);
        actor.modifyAttributeMaximum(AdditionalActorAttributes.STRENGTH, ActorAttributeOperations.INCREASE, STRENGTH);
        actor.removeItemFromInventory(this);
        return String.format("%s consumed by %s. %s feels stronger", this, actor, actor);
    }

    @Override
    public ActionList allowableActions(Actor otherActor) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(otherActor, this));
        return actions;
    }
}
