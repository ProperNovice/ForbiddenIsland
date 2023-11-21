package listCredentials;

import business.Credentials;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;

public class DeckTreasure extends ListCredentials {

	public DeckTreasure() {

		super.rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		super.layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		super.coordinatesList = Credentials.INSTANCE.cDeckTreasure;
		super.showListSize = true;

	}

}
