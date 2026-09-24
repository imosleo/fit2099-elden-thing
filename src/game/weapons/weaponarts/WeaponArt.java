package game.weapons.weaponarts;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public interface WeaponArt {
    /**
     * This method is used to define how the weapon art affect the actor .
     * For example, a weapon art can affect the attributes of the actor
     * while other, it may move the actor into a new location.
     *
     * @param actor  the actor who activated the weapon art
     * @param target the actor who is the target of the weapon art
     * @param map    the map on which the weapon art is executed
     * @return the description of what the weapon art did when it was activated
     */
    String execute(Actor actor, Actor target, GameMap map);
}
