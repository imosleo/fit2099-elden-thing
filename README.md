# Elden Thing

A text-based role-playing game in Java, built over three assignments on the FIT2099 game engine and designed around object-oriented principles. The player explores four maps of a dark-fantasy world, fights enemies with weapon arts, drinks flasks, trades with a suspicious merchant and recruits allies, while enemies spawn from the terrain and status effects like poison and stun change the rules of combat.

| | |
|---|---|
| **Team** | Ian Leong Zheng Yan, Kenzie Rivan Wiguna, Nicholas Hiew, Nathaniel Chin Wei Ming, Dylan Matthew Quah Kwang Yung |
| **Unit** | FIT2099 Object Oriented Design and Implementation, Monash University Malaysia |
| **Period** | Semester 2, 2024 (Assignments 1 to 3) |
| **Language** | Java 17, no external libraries |

The game engine (`src/edu/monash/fit2099/engine`) is provided by the unit and is unchanged. Everything under `src/game` is the team's work, 83 classes.

## What the game has

- **Four maps** connected by gates: Gravesite Plain, Belurat Tower Settlement, Belurat Sewers and the Stagefront.
- **Terrain that acts**: graveyards spawn spirits, puddles spawn scarabs, poison swamps poison anyone who stands in them.
- **Enemies** with their own behaviours: Furnace Golem, Divine Beast Dancing Lion (with wind, frost and lightning divine powers), Man-Fly, Scarab and Spirit. Defeated bosses drop remembrances that can be traded.
- **Combat**: intrinsic weapons and weapon items (short sword, great knife, bone arm, spawner staff and more) with weapon arts such as Quickstep, Lifesteal and Memento, and status effects (poison, stun, stat changers).
- **Consumables**: Flask of Healing, Flask of Rejuvenation, Shadowtree Fragment, Crimson Tear.
- **Trading** with a Suspicious Trader who buys and sells tradable items.
- **Allies**: the Fetcher, the Skeleton Soldier and the Stunning Jellyfish, each with follow, fetch or attack behaviours.
- **Snapshots** of actor attributes, used to restore state.

## Design

The codebase applies SOLID and DRY throughout, and each assignment came with a written design rationale and UML class and sequence diagrams (in `docs/design/`). Some of the patterns used:

| Pattern | Where |
|---|---|
| Abstract base classes for shared behaviour | `Enemy`, `Ally`, `WeaponItem`, `Consumable`, `GroundType` |
| Factory | `spawners/Factory`, `Spawner` and per-enemy spawners; `AttributeSnapshotFactory` |
| Strategy via behaviours | `AttackBehaviour`, `FollowBehaviour`, `WanderBehaviour`, `FetchBehaviour` chosen at runtime |
| Capability sets | `Ability`, `Status` enums to gate actions without `instanceof` chains |
| Command via actions | `AttackAction`, `ConsumeAction`, `TradeAction`, `TeleportAction`, `SpawnAction`, `DeathAction` |
| Memento | `utils/snapshot` package and the Memento weapon art |

## My contribution

From the contribution logs and class headers: the Assignment 2 requirement 1 implementation, requirement 2 design rationale and sequence diagram, the Death and Teleport actions, the poison effect, the Gate and Poison Swamp ground types, the game entry point and the end-of-game messages. Kenzie led the factory design, Nicholas and Nathaniel implemented requirements 3 and 4, and Dylan handled documentation and code review. The full log is in `docs/design/`.

## Run it

Requires a JDK (17 or later). No build tool is needed.

```bash
javac -d out $(find src -name "*.java")
java -cp out game.Application
```

On Windows PowerShell:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName })
java -cp out game.Application
```

Or open the folder in IntelliJ IDEA and run `game.Application`.

## Repository layout

```
fit2099-elden-thing/
├── src/edu/monash/fit2099/engine/   the unit's engine (unchanged)
├── src/edu/monash/fit2099/demo/     the unit's demo games (unchanged)
├── src/game/                        the team's game
│   ├── Application.java             entry point
│   ├── action/  actors/  allies/  behaviours/  consumables/  enemies/
│   ├── items/  maps/  spawners/  tileset/  utils/  weapons/
└── docs/design/
    ├── A2-DesignRationale.pdf, A3-DesignRationale.pdf   rationales with UML
    ├── engine.png, game.png, AttackAction.png            class diagrams
    ├── req4seq.puml                                      sequence diagram source
    ├── contribution log (PDF) and handover video links
    └── README_original.md                                the submission README
```

The engine and demo packages are copyright Monash University and are included as required to build the game.
