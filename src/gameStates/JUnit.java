package gameStates;

import adventurers.AdventurerPawn;
import cards.CardFlood;
import cards.CardTreasure;
import enums.EAdventurer;
import gameStatesDefault.GameState;
import model.BoardModel;
import model.PlayersModel;

public class JUnit extends GameState {

	@Override
	public void execute() {

		BoardModel.INSTANCE.setUpBoard();
		setUpPlayers();

		getListsManager().deckFlood.getArrayList().shuffle();
		getListsManager().deckFlood.relocateImageViews();
		getListsManager().deckTreasure.relocateImageViews();

		transferFloodCardsFromDeckToDiscardPile(9);
		transferTreasureCardsFromDeckToDiscardPile(3);

		getListsManager().tiles.loadOriginal();

		new AdventurerPawn(EAdventurer.Navigator);

		//

		getFlow().addFirst(DrawFloodCard.class, 6);
		proceedToNextGameState();

	}

	public void transferFloodCardsFromDeckToDiscardPile(int amount) {

		for (int counter = 1; counter <= amount; counter++) {

			CardFlood cardFlood = getListsManager().deckFlood.getArrayList().removeRandom();
			cardFlood.getImageView().flipFront();

			getListsManager().discardPileFlood.getArrayList().addFirst(cardFlood);

		}

		getListsManager().discardPileFlood.relocateImageViews();

	}

	public void transferTreasureCardsFromDeckToDiscardPile(int amount) {

		for (int counter = 1; counter <= amount; counter++) {

			CardTreasure cardFlood = getListsManager().deckTreasure.getArrayList().removeRandom();
			cardFlood.getImageView().flipFront();

			getListsManager().discardPileTreasure.getArrayList().addFirst(cardFlood);

		}

		getListsManager().discardPileTreasure.relocateImageViews();

	}

	public void setUpPlayers() {

		PlayersModel.INSTANCE.setUpPlayers();

	}

}
