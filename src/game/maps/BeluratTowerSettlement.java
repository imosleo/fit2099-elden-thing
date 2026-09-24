package game.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.tileset.Dirt;
import game.tileset.Floor;
import game.tileset.Puddle;
import game.tileset.Wall;

import java.util.Arrays;

public class BeluratTowerSettlement extends GameMap {
    public BeluratTowerSettlement() {
        super("Belurat, Tower Settlement", new FancyGroundFactory(new Dirt(), new Floor(), new Puddle(), new Wall()),
                Arrays.asList(
                        "###########........................##########",
                        "#____#____#......................._____#____#",
                        "#____#_.._#.#...~~~.......~~~....#____#____##",
                        "###_~~____###...~~~..~~~..~~~...####______###",
                        "###...____###..~~~~..~~~~..~~~...######_____#",
                        "##~~###..####..~~~...~~~.....~~~..####..#####",
                        "##__.....####..~~~.~~~~~..~~~....#####____###",
                        "###..##..##.#..~~..~~~~~..~~~~....####~..####",
                        "#....__..__.#..~~..~~~~~~..~~....__~~~~######",
                        "###########....................##############"
                ));
    }
}
