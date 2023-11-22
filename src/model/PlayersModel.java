package model;

import adventurers.Adventurer;
import boardPosition.BoardPositionLand;
import players.Player;
import players.PlayerBottom;
import players.PlayerTop;
import utils.ArrayList;

public enum PlayersModel {

	INSTANCE;

	private ArrayList<Player> players = new ArrayList<>();
	private PlayerTop playerTop = new PlayerTop();
	private PlayerBottom playerBottom = new PlayerBottom();

	private PlayersModel() {

	}

	public void setUpPlayers() {

		ArrayList<Adventurer> list = AdventurersModel.INSTANCE.getTwoRandomAdventurers();

		this.playerTop.setAdventurerRelocateCard(list.removeRandom());
		this.playerBottom.setAdventurerRelocateCard(list.removeRandom());

		this.players.addLast(this.playerTop);
		this.players.addLast(this.playerBottom);

		this.playerTop.getAdventurer().getAdventurerPawn().getImageView().setVisible(true);
		this.playerBottom.getAdventurer().getAdventurerPawn().getImageView().setVisible(true);

		BoardPositionLand boardPositionLand = IslandModel.INSTANCE
				.getBoardPositionLandWithAdventurerStartingPosition(
						this.playerTop.getAdventurer().getEAdventurer());

		boardPositionLand.addAdventurerPawnRelocate(this.playerTop);

		boardPositionLand = IslandModel.INSTANCE.getBoardPositionLandWithAdventurerStartingPosition(
				this.playerBottom.getAdventurer().getEAdventurer());

		boardPositionLand.addAdventurerPawnRelocate(this.playerBottom);

	}

}
