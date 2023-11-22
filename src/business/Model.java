package business;

import adventurers.Adventurer;
import boardPosition.BoardPosition;
import boardPosition.BoardPositionLand;
import boardPosition.BoardPositionWater;
import enums.EAdventurer;
import enums.EIslandLocation;
import gameStatesDefault.GameState;
import model.AdventurersModel;
import model.BoardModel;
import model.PlayersModel;
import players.Player;
import tiles.Tile;
import tiles.TileAdventurer;
import utils.ArrayList;
import utils.Flow;
import utils.Lock;
import utils.ShutDown;

public enum Model {

	INSTANCE;

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
