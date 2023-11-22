package listCredentials;

import business.Credentials;

public class PlayerIICardTreasure extends ListCredentials {

	public PlayerIICardTreasure() {

		super.coordinatesList = Credentials.INSTANCE.playerIICardTreasureList;
		super.objectsPerRow = 3;

	}

}
