package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Tradable;

/**
 * An action that represents a trade
 *
 * @author Nathaniel Chin
 */
public class TradeAction extends Action {
    private final Actor target;
    private final Tradable item;
    private final Item newitem;
    public TradeAction(Actor actor, Tradable item, Item newitem) {
        this.target = actor;
        this.item = item;
        this.newitem = newitem;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return item.trade(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s trades the %s with %s for %s", actor, item, target, newitem);
    }
}
