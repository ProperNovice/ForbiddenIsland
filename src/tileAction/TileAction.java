package tileAction;

import business.Credentials;
import tiles.Tile;
import utils.AnimationTimerFX;
import utils.Interfaces.IUpdateAble;
import utils.Lock;
import utils.Vector2;

public abstract class TileAction implements IUpdateAble {

	private Tile tile = null;
	private Vector2 coordinatesCenter = null;
	protected double currentPercentage, targetPercentage;

	public TileAction(Tile tile) {

		this.tile = tile;
		this.coordinatesCenter = this.tile.getImageView().getCoordinatesCenter().clone();
		this.currentPercentage = getStartingPercentage();
		this.targetPercentage = getTargetPercentage();

		AnimationTimerFX.INSTANCE.updateEachFrame(this);

		Lock.INSTANCE.lock();

	}

	@Override
	public final void update() {

		calculateNextPercentage();

		double width = this.currentPercentage * Credentials.INSTANCE.dTile.x / 100;
		this.tile.getImageView().setWidth(width);
		this.tile.getImageView().relocateCenter(this.coordinatesCenter);

		if (this.currentPercentage != this.targetPercentage)
			return;

		AnimationTimerFX.INSTANCE.remove(this);
		Lock.INSTANCE.unlock();

	}

	protected abstract double getStartingPercentage();

	protected abstract double getTargetPercentage();

	protected abstract void calculateNextPercentage();

}
