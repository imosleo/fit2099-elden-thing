package game.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.action.AttackAction;
import game.actors.Status;
import game.weapons.weaponarts.WeaponArt;

import java.util.Random;

/**
 * Class representing items that can be used as a weapon.
 *
 * Modified by:
 * Nathaniel Chin
 */
public abstract class WeaponItem extends Item implements Weapon {
    private static final float DEFAULT_DAMAGE_MULTIPLIER = 1.0f;
    private final int damage;
    private final int hitRate;
    private final String verb;
    private final float damageMultiplier;
    private WeaponArt weaponArt;

    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public WeaponItem(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, true);
        this.damage = damage;
        this.verb = verb;
        this.hitRate = hitRate;
        this.damageMultiplier = DEFAULT_DAMAGE_MULTIPLIER;
    }

    public void enchant(WeaponArt weaponArt) {
        if (this.weaponArt == null) {
            this.weaponArt = weaponArt;
        }
    }

    @Override
    public String attack(Actor attacker, Actor target, GameMap map) {
        Random rand = new Random();
        String result = "";
        if (!(rand.nextInt(100) < this.hitRate)) {
            result += attacker + " misses " + target + ".";
        } else {
            result += String.format("%s %s %s for %d damage", attacker, verb, target, damage);
            target.hurt(Math.round(damage * damageMultiplier));
        }
        // Check if weaponArt is not null before calling execute
        if (weaponArt != null) {
            result += weaponArt.execute(attacker, target, map);
        }
        return result;
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
            actions.add(new AttackAction(otherActor, location.toString(), this));
        }
        return actions;
    }
}
