package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.action.TradeAction;
import game.actors.Status;
import game.weapons.DivineBeastHead;
import game.weapons.WeaponItem;

/**
 * A class that represents the Remembrance of the Dancing Lion
 * <p>
 * Created by:
 * @author Nathaniel Chin
 * Modified by:
 * @author Dylan Matthew Quah Kwang Yung
 */
public class DancingLionRemembrance extends Item implements Tradable {
    private static final int hitpoints = 50;
    private static final int mana = 100;
    private final WeaponItem tradeItem;

    /**
     * Constructor.
     */
    public DancingLionRemembrance() {
        super("Remembrance of the Dancing Lion", '*', true);
        tradeItem = new DivineBeastHead();
    }

    @Override
    public String trade(Actor actor) {
        String retval = String.format("%s has been removed from %s's inventory%n", this, actor);
        actor.removeItemFromInventory(this);
        retval += String.format("%s is added to %s's inventory. %s feels stronger.", tradeItem, actor, actor);
        actor.addItemToInventory(tradeItem);
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, hitpoints);
        actor.modifyAttributeMaximum(BaseActorAttributes.MANA, ActorAttributeOperations.INCREASE, mana);
        return retval;
    }

    /**
     * Allow it to be traded with the trader
     *
     * @param otherActor the other actor
     * @param location   the location of the other actor
     * @return an unmodifiable list of Actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.TRADER)) {
            actions.add(new TradeAction(otherActor, this, tradeItem));
        }
        return actions;
    }
}
