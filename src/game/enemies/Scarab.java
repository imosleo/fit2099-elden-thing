package game.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.ConsumeAction;
import game.actors.Ability;
import game.actors.Status;
import game.actors.effects.StatChanger;
import game.behaviours.WanderBehaviour;
import game.consumables.Consumable;
import game.consumables.CrimsonTear;

/**
 * Class representing the Scarab
 * Modified by:
 *
 * @author Nathaniel Chin
 * @author Dylan Matthew Quah Kwang Yung
 */
public class Scarab extends Enemy implements Consumable {
    /**
     * How much HP the scarab has
     */
    private static final int HP = 25;
    /**
     * Amount of hitpoints increased and restored upon consumption
     */
    private static final int HEAL = 30;
    /**
     * Amount of mana increased and restored upon consumption
     */
    private static final int MANA_RESTORED = 50;
    /**
     * How long the effect lasts upon consumption
     */
    private static final int MAX_DURATION = 10;
    /**
     * How much damage is dealt in the explosion
     */
    private static final int EXPLOSION_DAMAGE = 25;

    /**
     * Constructor
     */
    public Scarab() {
        super("Scarab", 'b', HP);
        this.behaviours.put(3, new WanderBehaviour());
        this.addCapability(Ability.POISON_RES);
    }

    /**
     * Allows for the otherActor to either Consume or Attack the Scarab if it's considered to be hostile.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return ActionList
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new ConsumeAction(otherActor, this));
        }
        return actions;
    }

    /**
     * Causes an explosion effect like in FurnaceGolem's stomp upon death.
     * Drops a CrimsonTear item upon the ground where the Scarab met its demise
     *
     * @param actor the perpetrator
     * @param map   where the actor fell unconscious
     * @return a description of what happened.
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        Location here = map.locationOf(this);
        String retval = super.unconscious(actor, map);
        retval += String.format("%nThe scarab explodes");

        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) destination.getActor().hurt(EXPLOSION_DAMAGE);
        }

        map.at(here.x(), here.y()).addItem(new CrimsonTear());

        return retval;
    }

    /**
     * Increases the maximum capacity of the actor's Health and Mana.
     * Adds a hidden StatChanger item to Player's inventory that manages restoring the stats back to normal
     *
     * @param actor the actor who is consuming
     * @return the description of what the weapon did when the attack was performed
     */
    @Override
    public String consume(Actor actor) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, HEAL);
        actor.modifyAttributeMaximum(BaseActorAttributes.MANA, ActorAttributeOperations.INCREASE, MANA_RESTORED);
        actor.addStatusEffect(new StatChanger(HEAL, MANA_RESTORED, MAX_DURATION));
        return String.format("%s consumed %s. %s will feel the effects for another %s turns", actor, this, actor, MAX_DURATION);
    }

    /**
     * Removes this from the map upon consumption
     *
     * @param actor the actor who is consuming
     * @return the description of what the weapon did when the attack was performed
     */
    @Override
    public String consume(Actor actor, GameMap map) {
        map.removeActor(this);
        return this.consume(actor);
    }
}