package players;

import adventurers.Adventurer;
import listCredentials.ListCredentials;
import utils.Vector2;

public abstract class Player {

	private Adventurer adventurer = null;

	public Player() {

	}

	public final void setAdventurerRelocateCard(Adventurer adventurer) {

		this.adventurer = adventurer;
		this.adventurer.getAdventurerCard().getImageView()
				.relocateTopLeft(getCardAdventurerCoordinates());

		this.adventurer.getAdventurerCard().getImageView().setVisible(true);

	}

	public final Adventurer getAdventurer() {
		return this.adventurer;
	}

	protected abstract Vector2 getCardAdventurerCoordinates();

	protected abstract Class<? extends ListCredentials> getCardTreasureCoordinates();

}
