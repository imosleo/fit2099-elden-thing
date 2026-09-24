package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.consumables.Consumable;

/**
 * Class representing an action to consume
 * Note that the actor must have a consumable, e.g.,
 * a flask of healing or a shadowtree fragment.
 * Otherwise, the execute method will throw an error.
 *
 * @author Kenzie Rivan Wiguna
 */
public class ConsumeAction extends Action {

    /**
     * The Actor that consumes the consumable
     */
    private final Actor actor;

    /**
     * Consumable to be consumed
     */
    private final Consumable consumable;

    /**
     * Constructor.
     *
     * @param actor      the Actor to consume
     * @param consumable the Consumable to be consumed
     */
    public ConsumeAction(Actor actor, Consumable consumable) {
        this.actor = actor;
        this.consumable = consumable;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return consumable.consume(actor, map);
    }

    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s consumes %s", actor.toString(), consumable.toString());
    }
}
