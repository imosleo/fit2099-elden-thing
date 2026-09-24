package game.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.tileset.*;

import java.util.Arrays;

public class Stagefront extends GameMap {

    public Stagefront() {
        super("Stagefront", new FancyGroundFactory(new Dirt(), new Puddle(), new Wall()),
                Arrays.asList(
                        "#################",
                        "#~~~..........~~#",
                        "#~~~...........~#",
                        "#~~.............#",
                        "#............~~~#",
                        "#..........~~~~~#",
                        "#######...#######"
                )
        );
    }
}