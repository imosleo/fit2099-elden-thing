package game.consumables;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.action.ConsumeAction;

/**
 * Class representing a Crimson Tear
 *
 * Created by:
 * @author Nathaniel Chin
 *
 * Modified by:
 * @author Nathaniel Chin
 * @author Dylan Matthew Quah Kwang Yung
 */
public class CrimsonTear extends Item implements Consumable {
    /**
     * Amount of hitPoints restored
     */
    private static final int HEAL = 30;

    /**
     * Turns that the effect lasts
     */
    private static final int MAX_DURATION = 5;

    /**
     * How long this has been in effect
     */
    private int duration;

    /**
     * Whether the actor has consumed this yet
     */
    private boolean consumed;

    /***
     * Constructor.
     */
    public CrimsonTear() {
        super("Crimson Tear", '*', true);
        this.duration = 0;
        this.consumed = false;
    }

    /**
     * Heals the Player and starts the effects
     * Makes it non-portable and toggles the consumed attribute
     *
     * @param actor the actor who is consuming
     * @return the description of what the weapon did when the attack was performed
     */
    @Override
    public String consume(Actor actor) {
        this.consumed = true;
        this.togglePortability();
        return String.format("%s consumed by %s. %s will feel the effects for another %s turns", this, actor, actor, MAX_DURATION);
    }

    /**
     * If the consumed attribute is not true then allow the actor to consume the CrimsonTear
     *
     * @param otherActor the actor that owns the item
     * @return ActionList
     */
    @Override
    public ActionList allowableActions(Actor otherActor) {
        ActionList actions = new ActionList();
        if (!consumed) {
            actions.add(new ConsumeAction(otherActor, this));
        }
        return actions;
    }

    /**
     * Heals the actor on every turn after this has been consumed.
     * When the charges attribute reaches 0 delete this from their inventory.
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor           The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (consumed) {
            if (duration < MAX_DURATION) {
                actor.heal(HEAL);
                duration++;
            } else {
                Display display = new Display();
                display.println("The effect has worn off");
                actor.removeItemFromInventory(this);
            }
        }
    }
}