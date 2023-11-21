package cards;

import enums.EIslandLocation;
import utils.Interfaces.IImageViewAble;

public class CardFlood implements IImageViewAble {

	private EIslandLocation eIslandLocation = null;

	public CardFlood(EIslandLocation eIslandLocation) {

		this.eIslandLocation = eIslandLocation;
		createImageView();

	}

	private void createImageView() {

	}

	public EIslandLocation getEIslandLocation() {
		return this.eIslandLocation;
	}

}
