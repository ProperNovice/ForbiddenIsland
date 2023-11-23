package models;

import adventurers.Adventurer;
import enums.EAdventurer;
import utils.HashMap;

public enum AdventurersModel {

	INSTANCE;

	private HashMap<EAdventurer, Adventurer> hashMap = new HashMap<>();

	private AdventurersModel() {

		for (EAdventurer eAdventurer : EAdventurer.values())
			this.hashMap.put(eAdventurer, new Adventurer(eAdventurer));

	}

	public HashMap<EAdventurer, Adventurer> getAdventurers() {
		return this.hashMap;
	}

}
