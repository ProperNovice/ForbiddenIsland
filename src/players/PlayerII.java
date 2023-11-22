package players;

import business.Credentials;
import listCredentials.ListCredentials;
import listCredentials.PlayerIICardTreasure;
import utils.Vector2;

public class PlayerII extends Player {

	@Override
	protected Vector2 getCardAdventurerCoordinates() {
		return Credentials.INSTANCE.playerIIAdventurerCard;
	}

	@Override
	protected Class<? extends ListCredentials> getCardTreasureCoordinates() {
		return PlayerIICardTreasure.class;
	}

}
