package adventurers;

import enums.EAdventurer;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class AdventurerCard implements IImageViewAble {

	public AdventurerCard(EAdventurer eAdventurer) {

		String filePath = "cards/adventurers/";
		filePath += eAdventurer.toString();
		filePath += ".jpg";
		new ImageView(filePath, this);
		getImageView().setVisible(false);

	}

}
