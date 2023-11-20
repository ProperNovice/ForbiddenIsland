package gameStates;

import gameStatesDefault.GameState;
import model.Island;

public class JUnit extends GameState {

	@Override
	public void execute() {

		Island.INSTANCE.setUpBoard();

	}

}
