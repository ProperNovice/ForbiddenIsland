package gameStates;

import boardPosition.BoardPositionLand;
import business.Credentials;
import business.Model;
import cards.CardFlood;
import enums.EIslandLocation;
import gameStatesDefault.GameState;
import tileAction.TileActionEmbiggen;
import tileAction.TileActionShrink;
import tiles.Tile;

public class DrawFloodCard extends GameState {

	private CardFlood cardFlood = null;

	@Override
	public void execute() {

		if (getListsManager().deckFlood.getArrayList().isEmpty())
			shuffleFloodDiscardPileToDeck();

		drawFloodCard();
		handleTileAction();

	}

	private void shuffleFloodDiscardPileToDeck() {

		getListsManager().deckFlood.getArrayList()
				.addAllLast(getListsManager().discardPileFlood.getArrayList().clear());

		getListsManager().deckFlood.animateSynchronousLock();

		for (CardFlood cardFlood : getListsManager().deckFlood)
			cardFlood.getImageView().flip();

		getListsManager().deckFlood.getArrayList().shuffle();
		getListsManager().deckFlood.relocateImageViews();

	}

	private void drawFloodCard() {

		this.cardFlood = getListsManager().deckFlood.getArrayList().removeFirst();
		this.cardFlood.getImageView().flip();

		getListsManager().discardPileFlood.getArrayList().addFirst(this.cardFlood);
		getListsManager().discardPileFlood.animateSynchronousLock();

	}

	private void handleTileAction() {

		EIslandLocation eIslandLocation = this.cardFlood.getEIslandLocation();
		BoardPositionLand boardPositionLand = Model.INSTANCE
				.getBoardPositionLandContainingTile(eIslandLocation);
		Tile tile = boardPositionLand.getTile();

		if (tile.getImageView().isFlippedFront())
			floodTile(tile);
		else
			sinkTile(tile, boardPositionLand);

		proceedToNextGameState();

	}

	private void floodTile(Tile tile) {

		new TileActionShrink(tile);
		tile.getImageView().flip();
		new TileActionEmbiggen(tile);

	}

	private void sinkTile(Tile tile, BoardPositionLand boardPositionLand) {

		boardPositionLand.removeTile();
		new TileActionShrink(tile);

		tile.getImageView().setVisible(false);
		tile.getImageView().setDimensions(Credentials.INSTANCE.dTile);

		getListsManager().discardPileFlood.getArrayList().removeFirst().getImageView()
				.setVisible(false);

	}

}
