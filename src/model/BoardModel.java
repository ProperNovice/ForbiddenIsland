package model;

import boardPosition.BoardPosition;
import boardPosition.BoardPositionLand;
import boardPosition.BoardPositionWater;
import business.Credentials;
import utils.HashMap;
import utils.Vector2;

public enum BoardModel {

	INSTANCE;

	private HashMap<Integer, HashMap<Integer, BoardPosition>> hashMap = new HashMap<>();

	private BoardModel() {
		createBoardPositions();
	}

	public HashMap<Integer, HashMap<Integer, BoardPosition>> getBoard() {
		return this.hashMap;
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
