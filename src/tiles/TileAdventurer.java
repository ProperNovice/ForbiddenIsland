package tiles;

import enums.EAdventurer;
import enums.EIslandLocation;
import utils.Logger;

public class TileAdventurer extends Tile {

	private EAdventurer eAdventurer = null;

	public TileAdventurer(EIslandLocation eIslandLocation, EAdventurer eAdventurer) {

		super(eIslandLocation);
		this.eAdventurer = eAdventurer;

	}

	@Override
	protected void printCredentials() {
		Logger.INSTANCE.log(this.eAdventurer);
	}

	public EAdventurer getEAdventurer() {
		return this.eAdventurer;
	}

}
