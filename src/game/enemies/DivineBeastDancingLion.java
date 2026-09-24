package game.enemies;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.items.DancingLionRemembrance;
import game.tileset.Gate;
import game.weapons.DivinePower.Wind;
import game.weapons.LionBite;

public class DivineBeastDancingLion extends Enemy {
    private static final int HP = 10000;

    private final GameMap returnMap;  // Reference to the map where the gate will lead
    private static final int GATE_X_COORDINATE = 41;
    private static final int GATE_Y_COORDINATE = 1;

    public DivineBeastDancingLion(GameMap returnMap) {
        super("Divine Beast Dancing Lion", 'S', HP);
        this.returnMap = returnMap;
        this.behaviours.put(3, new WanderBehaviour());
        this.behaviours.put(1, new AttackBehaviour());
        this.setIntrinsicWeapon(new LionBite(new Wind()));
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            this.behaviours.put(2, new FollowBehaviour(otherActor));
        }
        return actions;
    }

    /**
     * When the boss is defeated, create a gate at its last location leading back to Belurat Tower Settlement.
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        // Get the boss's current location
        Location currentLocation = map.locationOf(this);

        // Remove the boss from the map
        map.removeActor(this);

        // Create a new gate at the boss's last location to Belurat Tower Settlement
        Gate returnGate = new Gate();

        // Set the return location to Belurat Tower Settlement at (41, 1)
        returnGate.addDestination(returnMap, returnMap.at(GATE_X_COORDINATE, GATE_Y_COORDINATE));

        // Set the ground at the current location to the gate
        currentLocation.setGround(returnGate);

        currentLocation.addItem(new DancingLionRemembrance());

        return "The Divine Beast Dancing Lion has been defeated! A new path back to Belurat Tower Settlement has opened.";
    }
}
