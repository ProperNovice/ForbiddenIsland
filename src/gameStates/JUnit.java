package gameStates;

import cards.CardFlood;
import gameStatesDefault.GameState;
import model.Island;

public class JUnit extends GameState {

	@Override
	public void execute() {

		Island.INSTANCE.setUpBoard();
		getListsManager().deckFlood.relocateImageViews();

		for (int counter = 1; counter <= 5; counter++) {

			CardFlood cardFlood = getListsManager().deckFlood.getArrayList().removeRandom();
			cardFlood.getImageView().flipFront();

			getListsManager().discardPileFlood.getArrayList().addFirst(cardFlood);
			getListsManager().discardPileFlood.animateSynchronousLock();

		}

		System.out.println("ended");

	}

}
