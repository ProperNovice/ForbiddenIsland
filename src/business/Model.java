package business;

import adventurers.Adventurer;
import boardPosition.BoardPosition;
import boardPosition.BoardPositionLand;
import boardPosition.BoardPositionWater;
import cards.CardTreasure;
import enums.EAdventurer;
import enums.EIslandLocation;
import enums.ETreasure;
import gameStatesDefault.GameState;
import models.AdventurersModel;
import models.BoardModel;
import models.PlayersModel;
import players.Player;
import tiles.Tile;
import tiles.TileAdventurer;
import utils.ArrayList;
import utils.Flow;
import utils.ListImageViewAbles;
import utils.Lock;
import utils.ShutDown;

public enum Model {

	INSTANCE;

	public void drawStartingHands() {

		for (Player player : PlayersModel.INSTANCE.getPlayers()) {

			ListImageViewAbles<CardTreasure> hand = player.getHand();

			while (hand.getArrayList().size() < 2) {

				CardTreasure cardTreasure = getListsManager().deckTreasure.getArrayList()
						.getRandom();

				if (cardTreasure.getETreasure().equals(ETreasure.WatersRise))
					continue;

				cardTreasure.getImageView().toFront();
				cardTreasure.getImageView().flip();

				getListsManager().deckTreasure.getArrayList().remove(cardTreasure);
				hand.getArrayList().addLast(cardTreasure);

			}

			hand.animateSynchronous();

		}

		Lock.INSTANCE.lock();

	}

	public BoardPositionLand getBoardPositionLandContainingTile(EIslandLocation eIslandLocation) {

		for (int row = 0; row < 6; row++) {

			for (int column = 0; column < 6; column++) {

				BoardPosition boardPosition = BoardModel.INSTANCE.getBoard().getValue(row)
						.getValue(column);

				if (boardPosition instanceof BoardPositionWater)
					continue;

				BoardPositionLand boardPositionLand = (BoardPositionLand) boardPosition;

				if (!boardPositionLand.containsTile())
					continue;

				Tile tile = boardPositionLand.getTile();

				if (!tile.getEIslandLocation().equals(eIslandLocation))
					continue;

				return boardPositionLand;

			}

		}

		ShutDown.INSTANCE.execute();
		return null;

	}

	public void setUpPlayers() {

		ArrayList<Adventurer> adventurers = new ArrayList<>();
		ArrayList<Player> players = PlayersModel.INSTANCE.getPlayers();

		// get two random adventurers

		ArrayList<EAdventurer> eAdventurers = new ArrayList<>(EAdventurer.values());

		adventurers.addLast(
				AdventurersModel.INSTANCE.getAdventurers().getValue(eAdventurers.removeRandom()));
		adventurers.addLast(
				AdventurersModel.INSTANCE.getAdventurers().getValue(eAdventurers.removeRandom()));

		// set up players and pawns

		for (Player player : players) {

			// set up player

			Adventurer adventurer = adventurers.removeRandom();

			player.setAdventurerRelocateCard(adventurer);

			// set up pawn

			player.getAdventurer().getAdventurerPawn().getImageView().setVisible(true);

			for (int row = 0; row < 6; row++) {

				for (int column = 0; column < 6; column++) {

					BoardPosition boardPosition = BoardModel.INSTANCE.getBoard().getValue(row)
							.getValue(column);

					if (boardPosition instanceof BoardPositionWater)
						continue;

					BoardPositionLand boardPositionLand = (BoardPositionLand) boardPosition;
					Tile tile = boardPositionLand.getTile();

					if (!(tile instanceof TileAdventurer))
						continue;

					TileAdventurer tileAdventurer = (TileAdventurer) tile;

					if (!tileAdventurer.getEAdventurer().equals(adventurer.getEAdventurer()))
						continue;

					double x = Credentials.INSTANCE.gapBetweenBorders
							+ 3 * Credentials.INSTANCE.dTile.x
							+ 2.5 * Credentials.INSTANCE.dGapBetweenComponents.x;
					double y = Credentials.INSTANCE.dFrame.y / 2;

					player.getAdventurer().getAdventurerPawn().getImageView().relocateCenter(x, y);
					boardPositionLand.addAdventurerPawnAnimateSynchronous(player);

				}

			}

		}

		Lock.INSTANCE.lock();

	}

	public void setUpBoard() {

		ListsManager.INSTANCE.tiles.loadOriginal();

		for (int row = 0; row < 6; row++) {

			for (int column = 0; column < 6; column++) {

				BoardPosition boardPosition = BoardModel.INSTANCE.getBoard().getValue(row)
						.getValue(column);

				if (boardPosition instanceof BoardPositionWater)
					continue;

				BoardPositionLand boardPositionLand = (BoardPositionLand) boardPosition;

				Tile tile = ListsManager.INSTANCE.tiles.removeRandom();
				boardPositionLand.addTileRelocate(tile);

			}

		}

	}

	protected ArrayList<Class<? extends GameState>> getFlow() {
		return Flow.INSTANCE.getFlow();
	}

	protected ListsManager getListsManager() {
		return ListsManager.INSTANCE;
	}

}
