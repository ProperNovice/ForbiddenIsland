package business;

import cards.CardFlood;
import enums.EAdventurer;
import enums.EIslandLocation;
import enums.ETreasure;
import tiles.TileAdventurer;
import tiles.TileBarren;
import tiles.TileTreasure;

public enum InstantiateComponents {

	INSTANCE;

	private InstantiateComponents() {

		instantiateTiles();
		instantiateDeckFlood();

		ListsManager.INSTANCE.saveListsOriginal();

	}

	private void instantiateDeckFlood() {

		for (EIslandLocation eIslandLocation : EIslandLocation.values())
			ListsManager.INSTANCE.deckFlood.getArrayList().addLast(new CardFlood(eIslandLocation));

	}

	private void instantiateTiles() {

		ListsManager.INSTANCE.tiles.addLast(new TileBarren(EIslandLocation.BreakersBridge));
		ListsManager.INSTANCE.tiles
				.addLast(new TileAdventurer(EIslandLocation.BronzeGate, EAdventurer.Engineer));
		ListsManager.INSTANCE.tiles.addLast(
				new TileTreasure(EIslandLocation.CaveOfEmbers, ETreasure.TheCrystalOfFire));
		ListsManager.INSTANCE.tiles.addLast(
				new TileTreasure(EIslandLocation.CaveOfShadows, ETreasure.TheCrystalOfFire));
		ListsManager.INSTANCE.tiles.addLast(new TileBarren(EIslandLocation.CliffsOfAbandon));
		ListsManager.INSTANCE.tiles
				.addLast(new TileAdventurer(EIslandLocation.CopperGate, EAdventurer.Explorer));
		ListsManager.INSTANCE.tiles
				.addLast(new TileTreasure(EIslandLocation.CoralPalace, ETreasure.TheOceansChalice));
		ListsManager.INSTANCE.tiles.addLast(new TileBarren(EIslandLocation.CrimsonForest));
		ListsManager.INSTANCE.tiles.addLast(new TileBarren(EIslandLocation.DunesOfDeception));
		ListsManager.INSTANCE.tiles
				.addLast(new TileAdventurer(EIslandLocation.FoolsLanding, EAdventurer.Pilot));
		ListsManager.INSTANCE.tiles
				.addLast(new TileAdventurer(EIslandLocation.GoldGate, EAdventurer.Navigator));
		ListsManager.INSTANCE.tiles.addLast(
				new TileTreasure(EIslandLocation.HowlingGarden, ETreasure.TheStatueOfTheWind));
		ListsManager.INSTANCE.tiles
				.addLast(new TileAdventurer(EIslandLocation.IronGate, EAdventurer.Diver));
		ListsManager.INSTANCE.tiles.addLast(new TileBarren(EIslandLocation.LostLagoon));
		ListsManager.INSTANCE.tiles.addLast(new TileBarren(EIslandLocation.MistyMarsh));
		ListsManager.INSTANCE.tiles.addLast(new TileBarren(EIslandLocation.Observatory));
		ListsManager.INSTANCE.tiles.addLast(new TileBarren(EIslandLocation.PhantomRock));
		ListsManager.INSTANCE.tiles
				.addLast(new TileAdventurer(EIslandLocation.SilverGate, EAdventurer.Messenger));
		ListsManager.INSTANCE.tiles.addLast(
				new TileTreasure(EIslandLocation.TempleOfTheMoon, ETreasure.TheEarthStone));
		ListsManager.INSTANCE.tiles
				.addLast(new TileTreasure(EIslandLocation.TempleOfTheSun, ETreasure.TheEarthStone));
		ListsManager.INSTANCE.tiles
				.addLast(new TileTreasure(EIslandLocation.TidalPalace, ETreasure.TheOceansChalice));
		ListsManager.INSTANCE.tiles.addLast(new TileBarren(EIslandLocation.TwilightHollow));
		ListsManager.INSTANCE.tiles.addLast(new TileBarren(EIslandLocation.Watchtower));
		ListsManager.INSTANCE.tiles.addLast(
				new TileTreasure(EIslandLocation.WhisperingGarden, ETreasure.TheStatueOfTheWind));

		ListsManager.INSTANCE.tiles.saveOriginal();

	}

}
