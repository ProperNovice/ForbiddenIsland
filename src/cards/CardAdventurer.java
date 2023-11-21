package cards;

import enums.EAdventurer;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;
import utils.Logger;

public class CardAdventurer implements IImageViewAble {

	private EAdventurer eAdventurer = null;

	public CardAdventurer(EAdventurer eAdventurer) {

		this.eAdventurer = eAdventurer;
		createImageView();

	}

	public void print() {

		Logger.INSTANCE.log("/*");
		Logger.INSTANCE.log(this.getClass().getSimpleName());
		Logger.INSTANCE.log(this.eAdventurer.toString());
		Logger.INSTANCE.logNewLine("*/");

	}

	@Override
	public void handleMousePressedPrimary() {
		print();
	}

	public EAdventurer getEAdventurer() {
		return this.eAdventurer;
	}

	private void createImageView() {

		String filePath = "cards/adventurers/";
		filePath += this.eAdventurer.toString();
		filePath += ".jpg";

		new ImageView(filePath, this);

	}

}
