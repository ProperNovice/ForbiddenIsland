package players;

import business.Credentials;
import listCredentials.ListCredentials;
import listCredentials.PlayerBottomCardTreasure;
import utils.Vector2;

public class PlayerBottom extends Player {

	@Override
	protected Vector2 getCardAdventurerCoordinates() {
		return Credentials.INSTANCE.playerBottomAdventurerCard;
	}

	@Override
	protected Class<? extends ListCredentials> getCardTreasureListCredentials() {
		return PlayerBottomCardTreasure.class;
	}

}
