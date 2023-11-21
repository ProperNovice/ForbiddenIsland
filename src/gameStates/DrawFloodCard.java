package gameStates;

import cards.CardFlood;
import enums.EIslandLocation;
import gameStatesDefault.GameState;
import model.Island;
import tileAction.TileActionEmbiggen;
import tileAction.TileActionShrink;
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

		if (tile.getImageView().isFlippedFront())
			floodTile(tile);
		else
			sinkTile(tile);

		proceedToNextGameState();

	}

	private void floodTile(Tile tile) {

		new TileActionShrink(tile);
		tile.getImageView().flip();
		new TileActionEmbiggen(tile);

	}

	private void sinkTile(Tile tile) {

	}

}
