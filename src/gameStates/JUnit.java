package gameStates;

import adventurers.Adventurer;
import boardPosition.BoardPositionLand;
import business.Model;
import cards.CardFlood;
import cards.CardTreasure;
import enums.EAdventurer;
import gameStatesDefault.GameState;
import models.AdventurersModel;
import models.BoardModel;
import models.PlayersModel;
import players.Player;

public class JUnit extends GameState {

	@Override
	public void execute() {

		getListsManager().deckFlood.getArrayList().shuffle();
		getListsManager().deckFlood.relocateImageViews();
		getListsManager().deckTreasure.getArrayList().shuffle();
		getListsManager().deckTreasure.relocateImageViews();

		Model.INSTANCE.setUpBoard();

		setUpPlayer(PlayersModel.INSTANCE.getPlayers().getFirst(), EAdventurer.Diver, 3, 3);
		setUpPlayer(PlayersModel.INSTANCE.getPlayers().getLast(), EAdventurer.Messenger, 3, 3);

//		Model.INSTANCE.setUpPlayers();
//		Model.INSTANCE.drawStartingHands();

//		transferFloodCardsFromDeckToDiscardPile(9);
//		transferTreasureCardsFromDeckToDiscardPile(3);

//		getFlow().addFirst(DrawFloodCard.class, 6);
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

	private void setUpPlayer(Player player, EAdventurer eAdventurer, int boardPositionX,
			int boardPositionY) {

		Adventurer adventurer = AdventurersModel.INSTANCE.getAdventurers().getValue(eAdventurer);
		adventurer.getAdventurerCard().getImageView().setVisible(true);
		adventurer.getAdventurerPawn().getImageView().setVisible(true);

		player.setAdventurerRelocateCard(adventurer);

		BoardPositionLand boardPositionLand = (BoardPositionLand) BoardModel.INSTANCE.getBoard()
				.getValue(boardPositionX).getValue(boardPositionY);

		boardPositionLand.addAdventurerPawnAnimateSynchronous(player);

	}

}
