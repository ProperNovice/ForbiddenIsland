package tiles;

import enums.EIslandLocation;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;
import utils.Logger;

public abstract class Tile implements IImageViewAble {

	private EIslandLocation eIslandLocation = null;

	public Tile(EIslandLocation eIslandLocation) {

		this.eIslandLocation = eIslandLocation;
		create();

	}

	public final void print() {

		Logger.INSTANCE.log("/*");
		Logger.INSTANCE.log(this.getClass().getSimpleName());
		Logger.INSTANCE.log(this.eIslandLocation);
		printCredentials();
		Logger.INSTANCE.logNewLine("*/");

	}

	protected void printCredentials() {

	}

	@Override
	public void handleMousePressedPrimary() {
		print();
	}

	public EIslandLocation getEIslandLocation() {
		return this.eIslandLocation;
	}

	private void create() {

		String filePath = "";

		// front

		filePath = "tiles/unflooded/";
		filePath += this.eIslandLocation.toString();
		filePath += ".jpg";

		new ImageView(filePath, this);

		// back

		filePath = "tiles/flooded/";
		filePath += this.eIslandLocation.toString();
		filePath += ".jpg";

		getImageView().setBack(filePath);

	}

}
