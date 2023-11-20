package boardPosition;

import tiles.Tile;
import utils.Interfaces.ISelectCoordinatesAble;
import utils.Vector2;

public class BoardPositionLand extends BoardPosition implements ISelectCoordinatesAble {

	private Vector2 coordinatesCenter = null;
	private Tile tile = null;

	public BoardPositionLand(Vector2 vector2) {
		this.coordinatesCenter = vector2.clone();
	}

	public void addTileRelocate(Tile tile) {

		this.tile = tile;
		this.tile.getImageView().relocateCenter(this.coordinatesCenter);

	}

	public Tile getTile() {
		return this.tile;
	}

	public void removeTileSetVisibleFalse() {

		this.tile.getImageView().setVisible(false);
		this.tile = null;

	}

	public boolean containsTile() {
		return this.tile != null;
	}

	@Override
	public Vector2 getCoordinatesCenter() {
		return this.coordinatesCenter;
	}

}
