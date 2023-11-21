package gameStates;

import cards.CardFlood;
import enums.EIslandLocation;
import gameStatesDefault.GameState;
import model.Island;
import tiles.Tile;

public class DrawFloodCard extends GameState {

	private CardFlood cardFlood = null;

	@Override
	public void execute() {

		drawFloodCard();
		handleTile();

	}

	private void drawFloodCard() {

		this.cardFlood = getListsManager().deckFlood.getArrayList().removeFirst();
		this.cardFlood.getImageView().flip();

		getListsManager().discardPileFlood.getArrayList().addFirst(this.cardFlood);
		getListsManager().discardPileFlood.animateSynchronousLock();

	}

	private void handleTile() {

		EIslandLocation eIslandLocation = this.cardFlood.getEIslandLocation();
		Tile tile = Island.INSTANCE.getTile(eIslandLocation);

		if (tile.isUnflooded())
			tile.floodTile();

	}

}
