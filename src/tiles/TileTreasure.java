package tiles;

import enums.EIslandLocation;
import enums.ETreasure;
import utils.Logger;

public class TileTreasure extends Tile {

	private ETreasure eTreasure = null;

	public TileTreasure(EIslandLocation eIslandLocation, ETreasure eTreasure) {

		super(eIslandLocation);
		this.eTreasure = eTreasure;

	}

	@Override
	protected void printCredentials() {
		Logger.INSTANCE.log(this.eTreasure);
	}

	public ETreasure getETreasure() {
		return this.eTreasure;
	}

}
