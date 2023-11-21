package cards;

import enums.ETreasure;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;
import utils.Logger;

public class CardTreasure implements IImageViewAble {

	private ETreasure eTreasure = null;

	public CardTreasure(ETreasure eTreasure) {

		this.eTreasure = eTreasure;
		createImageView();

	}

	public void print() {

		Logger.INSTANCE.log("/*");
		Logger.INSTANCE.log(this.getClass().getSimpleName());
		Logger.INSTANCE.log(this.eTreasure.toString());
		Logger.INSTANCE.logNewLine("*/");

	}

	@Override
	public void handleMousePressedPrimary() {
		print();
	}

	public ETreasure getETreasure() {
		return this.eTreasure;
	}

	private void createImageView() {

		String filePath = "cards/treasure/";
		filePath += this.eTreasure.toString();
		filePath += ".jpg";

		new ImageView(filePath, this);
		getImageView().setBack("cards/flood/back.jpg");

	}

}
