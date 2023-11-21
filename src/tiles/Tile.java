package tiles;

import enums.EIslandLocation;
import utils.AnimationTimerFX;
import utils.Image;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;
import utils.Interfaces.IUpdateAble;
import utils.Logger;
import utils.Vector2;

public abstract class Tile implements IImageViewAble, IUpdateAble {

	private EIslandLocation eIslandLocation = null;
	private Image unflooded, flooded;
	private Vector2 coordinatesCenter = null;

	public Tile(EIslandLocation eIslandLocation) {

		this.eIslandLocation = eIslandLocation;
		create();

	}

	public final void floodTile() {

		this.coordinatesCenter = getImageView().getCoordinatesCenter().clone();
		AnimationTimerFX.INSTANCE.updateEachFrame(this);

//		getImageView().setImage(this.flooded);

	}

	public final void unfloodTile() {
		getImageView().setImage(this.unflooded);
	}

	public final boolean isUnflooded() {
		return this.getImageView().getImageShowing().equals(this.unflooded);
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

	@Override
	public void update() {

	}

	private void create() {

		String filePath = "";

		// un-flooded

		filePath = "tiles/unflooded/";
		filePath += this.eIslandLocation.toString();
		filePath += ".jpg";

		this.unflooded = new Image(filePath);

		// flooded

		filePath = "tiles/flooded/";
		filePath += this.eIslandLocation.toString();
		filePath += ".jpg";

		this.flooded = new Image(filePath);

		// image view

		new ImageView(this.unflooded, this);

	}

}
