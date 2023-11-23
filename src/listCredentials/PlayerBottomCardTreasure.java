package listCredentials;

import business.Credentials;
import utils.Enums.DirectionEnum;

public class PlayerBottomCardTreasure extends ListCredentials {

	public PlayerBottomCardTreasure() {

		super.coordinatesList = Credentials.INSTANCE.playerBottomCardTreasureList;
		super.objectsPerRow = 3;
		super.capacity = 5;
		super.directionEnumVertical = DirectionEnum.UP;

	}

}
