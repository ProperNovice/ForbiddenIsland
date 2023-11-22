package adventurers;

import enums.EAdventurer;

public class Adventurer {

	private EAdventurer eAdventurer = null;
	private AdventurerCard adventurerCard = null;
	private AdventurerPawn adventurerPawn = null;

	public Adventurer(EAdventurer eAdventurer) {

		this.eAdventurer = eAdventurer;
		this.adventurerCard = new AdventurerCard(eAdventurer);
		this.adventurerPawn = new AdventurerPawn(eAdventurer);

	}

	public EAdventurer getEAdventurer() {
		return this.eAdventurer;
	}

	public AdventurerCard getAdventurerCard() {
		return this.adventurerCard;
	}

	public AdventurerPawn getAdventurerPawn() {
		return this.adventurerPawn;
	}

}
