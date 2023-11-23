package models;

import players.Player;
import players.PlayerBottom;
import players.PlayerTop;
import utils.ArrayList;

public enum PlayersModel {

	INSTANCE;

	private ArrayList<Player> players = new ArrayList<>();

	private PlayersModel() {

		this.players.addLast(new PlayerTop());
		this.players.addLast(new PlayerBottom());

	}

	public ArrayList<Player> getPlayers() {
		return this.players;
	}

}
