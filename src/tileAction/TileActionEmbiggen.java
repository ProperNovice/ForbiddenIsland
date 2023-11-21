package tileAction;

import business.Credentials;
import tiles.Tile;

public class TileActionEmbiggen extends TileAction {

	public TileActionEmbiggen(Tile tile) {
		super(tile);
	}

	@Override
	protected double getStartingPercentage() {
		return 0;
	}

	@Override
	protected double getTargetPercentage() {
		return 100;
	}

	@Override
	protected void calculateNextPercentage() {
		super.currentPercentage += Credentials.INSTANCE.tileActionPercentage;
	}

}
