package players;

import business.Credentials;
import listCredentials.ListCredentials;
import listCredentials.PlayerTopCardTreasure;
import utils.Vector2;

public class PlayerTop extends Player {

	@Override
	protected Vector2 getCardAdventurerCoordinates() {
		return Credentials.INSTANCE.playerTopAdventurerCard;
	}

	@Override
	protected Class<? extends ListCredentials> getCardTreasureCoordinates() {
		return PlayerTopCardTreasure.class;
	}

}
