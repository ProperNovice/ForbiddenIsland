package gameStates;

import boardPosition.BoardPositionLand;
import business.Model;
import enums.EText;
import gameStatesDefault.GameState;
import utils.ArrayList;

public abstract class SelectAction extends GameState {

	@Override
	public void execute() {

		EText.ACTION.showAdditionally(getCurrentAction());

		move();
		shoreUp();
		giveTreasureCard();
		captureTreasure();

		EText.END_TURN.show();

	}

	@Override
	protected final void executeTextOption(EText eText) {

		proceedToNextGameState();

	}

	private void move() {

		ArrayList<BoardPositionLand> list = Model.INSTANCE.getBoardPositionsAvailableToMove();

		for (BoardPositionLand boardPositionLand : list)
			boardPositionLand.setSelected();

		EText.MOVE.show();

	}

	private void shoreUp() {

		EText.SHORE_UP.show();

	}

	private void giveTreasureCard() {

		EText.GIVE_TREASURE_CARD.show();

	}

	private void captureTreasure() {

		EText.CAPTURE_TREASURE.show();

	}

	protected abstract int getCurrentAction();

}
