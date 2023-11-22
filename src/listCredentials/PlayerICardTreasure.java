package listCredentials;

import business.Credentials;

public class PlayerICardTreasure extends ListCredentials {

	public PlayerICardTreasure() {

		super.coordinatesList = Credentials.INSTANCE.playerICardTreasureList;
		super.objectsPerRow = 3;

	}

}
