package players;

import business.Credentials;
import listCredentials.ListCredentials;
import listCredentials.PlayerICardTreasure;
import utils.Vector2;

public class PlayerI extends Player {

	@Override
	protected Vector2 getCardAdventurerCoordinates() {
		return Credentials.INSTANCE.playerIAdventurerCard;
	}

	@Override
	protected Class<? extends ListCredentials> getCardTreasureCoordinates() {
		return PlayerICardTreasure.class;
	}

}
