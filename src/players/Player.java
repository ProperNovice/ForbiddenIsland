package players;

import adventurers.Adventurer;
import cards.CardTreasure;
import listCredentials.ListCredentials;
import utils.ListImageViewAbles;
import utils.Vector2;

public abstract class Player {

	private Adventurer adventurer = null;
	private ListImageViewAbles<CardTreasure> hand = new ListImageViewAbles<>(
			getCardTreasureListCredentials());

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

	public final ListImageViewAbles<CardTreasure> getHand() {
		return this.hand;
	}

	protected abstract Vector2 getCardAdventurerCoordinates();

	protected abstract Class<? extends ListCredentials> getCardTreasureListCredentials();

}
