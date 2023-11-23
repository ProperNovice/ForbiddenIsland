package boardPosition;

import adventurers.AdventurerPawn;
import listCredentials.BoardPositionList;
import players.Player;
import tiles.Tile;
import utils.Interfaces.ISelectCoordinatesAble;
import utils.ListImageViewAbles;
import utils.Vector2;

public class BoardPositionLand extends BoardPosition implements ISelectCoordinatesAble {

	private Vector2 coordinatesCenter = null;
	private Tile tile = null;
	private ListImageViewAbles<AdventurerPawn> listPawns = null;

	public BoardPositionLand(Vector2 vector2) {

		this.coordinatesCenter = vector2.clone();

		this.listPawns = new ListImageViewAbles<>(BoardPositionList.class);
		this.listPawns.getListCredentials().coordinatesList = this.coordinatesCenter;

	}

	public void addTileRelocate(Tile tile) {

		this.tile = tile;
		this.tile.getImageView().relocateCenter(this.coordinatesCenter);

	}

	public Tile getTile() {
		return this.tile;
	}

	public void removeTile() {
		this.tile = null;
	}

	public boolean containsTile() {
		return this.tile != null;
	}

	public void addAdventurerPawnAnimateSynchronous(Player player) {

		this.listPawns.getArrayList().addLast(player.getAdventurer().getAdventurerPawn());
//		this.listPawns.animateSynchronous();
		this.listPawns.relocateImageViews();

	}

	@Override
	public Vector2 getCoordinatesCenter() {
		return this.coordinatesCenter;
	}

}
