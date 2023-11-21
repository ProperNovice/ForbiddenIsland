package listCredentials;

import business.Credentials;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;

public class DiscardPileTreasure extends ListCredentials {

	public DiscardPileTreasure() {

		super.rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		super.layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		super.coordinatesList = Credentials.INSTANCE.cDiscardPileTreasure;

	}

}
