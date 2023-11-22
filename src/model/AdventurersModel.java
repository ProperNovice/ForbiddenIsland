package model;

import adventurers.Adventurer;
import enums.EAdventurer;
import utils.ArrayList;
import utils.HashMap;

public enum AdventurersModel {

	INSTANCE;

	private HashMap<EAdventurer, Adventurer> hashMap = new HashMap<>();

	private AdventurersModel() {

		for (EAdventurer eAdventurer : EAdventurer.values())
			this.hashMap.put(eAdventurer, new Adventurer(eAdventurer));

	}

	public ArrayList<Adventurer> getTwoRandomAdventurers() {

		ArrayList<EAdventurer> eAdventurers = new ArrayList<>(EAdventurer.values());
		ArrayList<Adventurer> adventurers = new ArrayList<>();

		adventurers.addLast(this.hashMap.getValue(eAdventurers.removeRandom()));

		return adventurers;

	}

}
