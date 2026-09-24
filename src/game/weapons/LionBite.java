package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.weapons.DivinePower.DivinePower;

import java.util.Random;

/**
 * Represents the bite attack for Divine Beast Dancing Lion.
 */
public class LionBite extends IntrinsicWeapon {
    private static final int POWER_CHANGE = 25;

    private static final int DAMAGE = 150;
    private static final int HITRATE = 30;

    private DivinePower divinePower;
    /**
     * Constructor for LionBite.
     */
    public LionBite(DivinePower divinePower) {
        super(DAMAGE, "bites", HITRATE);  // Deals 150 damage with 30% hit chance
        this.divinePower = divinePower;
    }

    @Override
    public String attack(Actor attacker, Actor target, GameMap map) {
        String result = "";
        Random rand = new Random();
        if (rand.nextInt(100) < POWER_CHANGE) {
            divinePower = divinePower.nextPower();
        }
        result += divinePower.execute(attacker, target, map) + "\n";
        result += super.attack(attacker, target, map);
        return result;
    }
}