package model;

import boardPosition.BoardPosition;
import boardPosition.BoardPositionLand;
import boardPosition.BoardPositionWater;
import business.Credentials;
import business.ListsManager;
import enums.EAdventurer;
import enums.EIslandLocation;
import tiles.Tile;
import tiles.TileAdventurer;
import utils.HashMap;
import utils.ShutDown;
import utils.Vector2;

public enum IslandModel {

	INSTANCE;

	private HashMap<Integer, HashMap<Integer, BoardPosition>> hashMap = new HashMap<>();

	private IslandModel() {
		createBoardPositions();
	}

	public BoardPositionLand getBoardPositionLandWithAdventurerStartingPosition(EAdventurer eAdventurer) {

		for (int row = 0; row < 6; row++) {

			for (int column = 0; column < 6; column++) {

				BoardPosition boardPosition = this.hashMap.getValue(row).getValue(column);

				if (boardPosition instanceof BoardPositionWater)
					continue;

				BoardPositionLand boardPositionLand = (BoardPositionLand) boardPosition;
				Tile tile = boardPositionLand.getTile();

				if (!(tile instanceof TileAdventurer))
					continue;

				TileAdventurer tileAdventurer = (TileAdventurer) tile;

				if (!tileAdventurer.getEAdventurer().equals(eAdventurer))
					continue;

				return boardPositionLand;

			}

		}

		ShutDown.INSTANCE.execute();
		return null;

	}

	public BoardPositionLand getBoardPositionLandContainingTile(EIslandLocation eIslandLocation) {

		for (int row = 0; row < 6; row++) {

			for (int column = 0; column < 6; column++) {

				BoardPosition boardPosition = this.hashMap.getValue(row).getValue(column);

				if (boardPosition instanceof BoardPositionWater)
					continue;

				BoardPositionLand boardPositionLand = (BoardPositionLand) boardPosition;

				if (!boardPositionLand.containsTile())
					continue;

				Tile tile = boardPositionLand.getTile();

				if (!tile.getEIslandLocation().equals(eIslandLocation))
					continue;

				return boardPositionLand;

			}

		}

		ShutDown.INSTANCE.execute();
		return null;

	}

	public void setUpBoard() {

		ListsManager.INSTANCE.tiles.loadOriginal();

		for (int row = 0; row < 6; row++) {

			for (int column = 0; column < 6; column++) {

				BoardPosition boardPosition = this.hashMap.getValue(row).getValue(column);

				if (boardPosition instanceof BoardPositionWater)
					continue;

				BoardPositionLand boardPositionLand = (BoardPositionLand) boardPosition;
				Tile tile = ListsManager.INSTANCE.tiles.removeRandom();
				boardPositionLand.addTileRelocate(tile);

			}

		}

	}

	private void createBoardPositions() {

		Vector2 coordinatesFirstBoardPosition = Credentials.INSTANCE.cBoardPosition.clone();

		//

		createRow(0, 2, coordinatesFirstBoardPosition);

		//

		coordinatesFirstBoardPosition.y += Credentials.INSTANCE.dGapBetweenComponents.y;
		coordinatesFirstBoardPosition.y += Credentials.INSTANCE.dTile.y;

		createRow(1, 1, coordinatesFirstBoardPosition);

		//

		coordinatesFirstBoardPosition.y += Credentials.INSTANCE.dGapBetweenComponents.y;
		coordinatesFirstBoardPosition.y += Credentials.INSTANCE.dTile.y;

		createRow(2, 0, coordinatesFirstBoardPosition);

		//

		coordinatesFirstBoardPosition.y += Credentials.INSTANCE.dGapBetweenComponents.y;
		coordinatesFirstBoardPosition.y += Credentials.INSTANCE.dTile.y;

		createRow(3, 0, coordinatesFirstBoardPosition);

		//

		coordinatesFirstBoardPosition.y += Credentials.INSTANCE.dGapBetweenComponents.y;
		coordinatesFirstBoardPosition.y += Credentials.INSTANCE.dTile.y;

		createRow(4, 1, coordinatesFirstBoardPosition);

		//

		coordinatesFirstBoardPosition.y += Credentials.INSTANCE.dGapBetweenComponents.y;
		coordinatesFirstBoardPosition.y += Credentials.INSTANCE.dTile.y;

		createRow(5, 2, coordinatesFirstBoardPosition);

	}

	private void createRow(int row, int boardPositionWater, Vector2 coordinatesFirstBoardPosition) {

		coordinatesFirstBoardPosition = coordinatesFirstBoardPosition.clone();

		HashMap<Integer, BoardPosition> columnMap = new HashMap<>();
		this.hashMap.put(row, columnMap);

		for (int column = 0; column < 6; column++) {

			if (column < boardPositionWater)
				columnMap.put(column, new BoardPositionWater());
			else if (6 - column <= boardPositionWater)
				columnMap.put(column, new BoardPositionWater());
			else
				columnMap.put(column, new BoardPositionLand(coordinatesFirstBoardPosition));

			coordinatesFirstBoardPosition.x += Credentials.INSTANCE.dGapBetweenComponents.x;
			coordinatesFirstBoardPosition.x += Credentials.INSTANCE.dTile.x;

		}

	}

}
