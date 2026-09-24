package game.actors.effects;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.StatusEffect;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;

public class StunnedEffect extends StatusEffect {
    private final int duration;
    private int counter;

    public StunnedEffect(int duration) {
        super("Stunned");
        this.duration = duration;
        counter = 0;
    }

    @Override
    public void tick(Location location, Actor actor) {
        super.tick(location, actor);
        if (counter >= duration) {
            actor.removeCapability(Status.STUNNED);
            actor.removeStatusEffect(this);
        }
        counter++;
    }
}