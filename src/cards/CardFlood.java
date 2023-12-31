package cards;

import enums.EIslandLocation;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;
import utils.Logger;

public class CardFlood implements IImageViewAble {

	private EIslandLocation eIslandLocation = null;

	public CardFlood(EIslandLocation eIslandLocation) {

		this.eIslandLocation = eIslandLocation;
		createImageView();

	}

	public void print() {

		Logger.INSTANCE.log("/*");
		Logger.INSTANCE.log(this.getClass().getSimpleName());
		Logger.INSTANCE.log(this.eIslandLocation.toString());
		Logger.INSTANCE.logNewLine("*/");

	}

	@Override
	public void handleMousePressedPrimary() {
		print();
	}

	public EIslandLocation getEIslandLocation() {
		return this.eIslandLocation;
	}

	private void createImageView() {

		String filePath = "cards/flood/";
		filePath += this.eIslandLocation.toString();
		filePath += ".jpg";

		new ImageView(filePath, this);
		getImageView().setBack("cards/flood/back.jpg");
		getImageView().flipBack();

	}

}
