package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A class that represents the Suspicious Trader
 *
 * Created by:
 * @author Nathaniel Chin
 */
public class SuspiciousTrader extends Actor {

    /**
     * The constructor of the Actor class.
     */
    public SuspiciousTrader() {
        super("Suspicious Trader", 'ඞ', 10000);
        this.addCapability(Status.TRADER);
    }

    /**
     * Do nothing
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
}
