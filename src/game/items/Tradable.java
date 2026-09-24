package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface that represents a tradable item
 *
 * Created by:
 * @author Nathaniel Chin
 */
public interface Tradable {
    /**
     * The action that occurs when a trade happens
     *
     * @param actor the actor that is being traded with
     * @return a description of what happens during a trade
     */
    String trade(Actor actor);
}
