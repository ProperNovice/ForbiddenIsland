package tileAction;

import business.Credentials;
import tiles.Tile;

public class TileActionShrink extends TileAction {

	public TileActionShrink(Tile tile) {
		super(tile);
	}

	@Override
	protected double getStartingPercentage() {
		return 100;
	}

	@Override
	protected double getTargetPercentage() {
		return 0;
	}

	@Override
	protected void calculateNextPercentage() {
		super.currentPercentage -= Credentials.INSTANCE.tileActionPercentage;
	}

}
