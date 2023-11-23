package listCredentials;

import business.Credentials;

public class PlayerTopCardTreasure extends ListCredentials {

	public PlayerTopCardTreasure() {

		super.coordinatesList = Credentials.INSTANCE.playerTopCardTreasureList;
		super.objectsPerRow = 3;
		super.capacity = 5;

	}

}
