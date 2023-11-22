package adventurers;

import business.Credentials;
import enums.EAdventurer;
import enums.ELayerZ;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public class AdventurerPawn implements IImageViewAble {

	public AdventurerPawn(EAdventurer eAdventurer) {

		String filePath = "pawns/";
		filePath += eAdventurer.toString();
		filePath += ".png";
		new ImageView(filePath, ELayerZ.PAWNS, this);
		getImageView().setDimensions(Credentials.INSTANCE.dAdventurerPawn);
		getImageView().setVisible(false);

	}

}
