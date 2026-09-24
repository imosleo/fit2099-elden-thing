package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttribute;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.DeathAction;
import game.utils.FancyMessage;
import game.weapons.BareFist;

/**
 * Class representing the Player.
 * Created by:
 *
 * @author Adrian Kristanto
 * Modified by: Kenzie Rivan Wiguna
 */
public class Player extends Actor {
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitPoints
     * @param mana        Player's starting number of mana
     * @param strength    Player's starting number of strength
     */
    public Player(String name, char displayChar, int hitPoints, int mana, int strength) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.setIntrinsicWeapon(new BareFist());
        this.addAttribute(BaseActorAttributes.MANA, new BaseActorAttribute(mana));
        this.addAttribute(AdditionalActorAttributes.STRENGTH, new BaseActorAttribute(strength));
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        if (!isConscious()) {
            return new DeathAction(this);
        }

        // Display player's stats
        display.println(toString());
        display.println("Mana:" + " (" + getAttribute(BaseActorAttributes.MANA) + '/' + getAttributeMaximum(BaseActorAttributes.MANA) + ')');
        display.println("Strength: " + getAttribute(AdditionalActorAttributes.STRENGTH));

        // return/print the console menu
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
    }

    @Override
    public String unconscious(Actor actor, GameMap map) {
        map.removeActor(this);
        return FancyMessage.YOU_DIED;
    }
}
