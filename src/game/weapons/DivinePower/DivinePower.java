package game.weapons.DivinePower;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public interface DivinePower {
    String execute(Actor attacker, Actor target, GameMap map);
    DivinePower nextPower();
}
