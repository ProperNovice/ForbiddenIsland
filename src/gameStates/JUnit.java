package gameStates;

import cards.CardFlood;
import cards.CardTreasure;
import gameStatesDefault.GameState;
import model.Island;

public class JUnit extends GameState {

	@Override
	public void execute() {

		Island.INSTANCE.setUpBoard();
		getListsManager().deckFlood.relocateImageViews();
		getListsManager().deckTreasure.relocateImageViews();
		
		transferTreasureCardsFromDeckToDiscardPile(3);

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

}
