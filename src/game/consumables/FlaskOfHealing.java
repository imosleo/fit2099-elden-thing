package game.consumables;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.action.ConsumeAction;

/**
 * Class representing a flask of healing
 *
 * @author Kenzie Rivan Wiguna
 */
public class FlaskOfHealing extends Item implements Consumable {

    /**
     * Amount of hitPoints restored
     */
    private static final int HEAL = 150;

    /**
     * Amount of times can be used
     */
    private static final int MAX_CHARGES = 5;

    /**
     * Amount of times that the Flask has been used
     */
    private int charges;

    /**
     * Constructor
     */
    public FlaskOfHealing() {
        super("Flask of Healing", 'u', true);
        this.charges = 0;
    }

    @Override
    public String consume(Actor actor) {
        if (charges < MAX_CHARGES) {
            actor.heal(HEAL);
            charges++;
            return String.format("%s consumed by %s. %s is healed", this, actor, actor);
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