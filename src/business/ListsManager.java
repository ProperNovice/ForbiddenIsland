package business;

import cards.CardFlood;
import listCredentials.DeckFlood;
import listCredentials.DiscardPileFlood;
import tiles.Tile;
import utils.ArrayList;
import utils.Interfaces.IImageViewAble;
import utils.ListImageViewAbles;

public enum ListsManager {

	INSTANCE;

	public final ArrayList<ListImageViewAbles<IImageViewAble>> lists = new ArrayList<ListImageViewAbles<IImageViewAble>>();
	public ArrayList<Tile> tiles;
	public ListImageViewAbles<CardFlood> deckFlood, discardPileFlood;

	public void instantiate() {

		this.tiles = new ArrayList<>();
		this.deckFlood = new ListImageViewAbles<>(DeckFlood.class);
		this.discardPileFlood = new ListImageViewAbles<>(DiscardPileFlood.class);

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
