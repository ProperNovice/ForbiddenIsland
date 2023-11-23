package listCredentials;

import business.Credentials;

public class PlayerBottomCardTreasure extends ListCredentials {

	public PlayerBottomCardTreasure() {

		super.coordinatesList = Credentials.INSTANCE.playerBottomCardTreasureList;
		super.objectsPerRow = 3;
		super.capacity = 5;

	}

}
