package models;

import players.Player;
import players.PlayerBottom;
import players.PlayerTop;
import utils.ArrayList;

public enum PlayersModel {

	INSTANCE;

	private ArrayList<Player> players = new ArrayList<>();
	private Player currentPlayer = null;

	private PlayersModel() {

		this.players.addLast(new PlayerTop());
		this.players.addLast(new PlayerBottom());

		this.currentPlayer = this.players.getFirst();

	}

	public void changeCurrentPlayer() {

		for (Player player : this.players) {

			if (this.currentPlayer.equals(player))
				continue;

			this.currentPlayer = player;
			break;

		}

	}

	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}

	public ArrayList<Player> getPlayers() {
		return this.players;
	}

}
