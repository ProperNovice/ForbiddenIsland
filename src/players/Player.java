package players;

import adventurers.Adventurer;
import listCredentials.ListCredentials;
import utils.Vector2;

public abstract class Player {

	private Adventurer adventurer = null;

	public Player() {

	}

	public final void setAdventurer(Adventurer adventurer) {
		this.adventurer = adventurer;
	}

	protected abstract Vector2 getCardAdventurerCoordinates();

	protected abstract Class<? extends ListCredentials> getCardTreasureCoordinates();

}
