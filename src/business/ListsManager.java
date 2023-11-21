package business;

import cards.CardFlood;
import cards.CardTreasure;
import listCredentials.DeckFlood;
import listCredentials.DeckTreasure;
import listCredentials.DiscardPileFlood;
import listCredentials.DiscardPileTreasure;
import tiles.Tile;
import utils.ArrayList;
import utils.Interfaces.IImageViewAble;
import utils.ListImageViewAbles;

public enum ListsManager {

	INSTANCE;

	public final ArrayList<ListImageViewAbles<IImageViewAble>> lists = new ArrayList<ListImageViewAbles<IImageViewAble>>();
	public ArrayList<Tile> tiles;
	public ListImageViewAbles<CardFlood> deckFlood, discardPileFlood;
	public ListImageViewAbles<CardTreasure> deckTreasure, discardPileTreasure;

	public void instantiate() {

		this.tiles = new ArrayList<>();
		this.deckFlood = new ListImageViewAbles<>(DeckFlood.class);
		this.discardPileFlood = new ListImageViewAbles<>(DiscardPileFlood.class);
		this.deckTreasure = new ListImageViewAbles<>(DeckTreasure.class);
		this.discardPileTreasure = new ListImageViewAbles<>(DiscardPileTreasure.class);

	}

	public void saveListsOriginal() {

		for (ListImageViewAbles<IImageViewAble> list : this.lists)
			list.getArrayList().saveOriginal();

	}

	public void loadListsOriginal() {

		for (ListImageViewAbles<IImageViewAble> list : this.lists)
			list.getArrayList().clear();

		for (ListImageViewAbles<IImageViewAble> list : this.lists)
			list.getArrayList().loadOriginal();

	}

}
