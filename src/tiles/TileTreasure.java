package tiles;

import treasures.Treasure;

public abstract class TileTreasure extends Tile {

	public abstract Class<? extends Treasure> getTreasure();

}
