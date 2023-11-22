package model;

import adventurers.Adventurer;
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

	public void createPlayers() {

		ArrayList<Adventurer> list = AdventurersModel.INSTANCE.getTwoRandomAdventurers();

		System.out.println(list.size());
		
		this.playerTop.setAdventurerRelocateCard(list.removeRandom());
		this.playerBottom.setAdventurerRelocateCard(list.removeRandom());

	}

}
