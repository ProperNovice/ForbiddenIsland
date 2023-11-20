package tiles;

import utils.Image;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;

public abstract class Tile implements IImageViewAble {

	private Image unflooded, flooded;

	public Tile() {
		create();
	}

	public void floodTile() {
		getImageView().setImage(this.flooded);
	}

	public void unfloodTile() {
		getImageView().setImage(this.unflooded);
	}

	private void create() {

		String filePath = "";

		// un-flooded

		filePath = "tiles/unflooded/";
		filePath += this.getClass().getSimpleName();
		filePath += ".jpg";

		this.unflooded = new Image(filePath);

		// flooded

		filePath = "tiles/flooded/";
		filePath += this.getClass().getSimpleName();
		filePath += ".jpg";

		this.flooded = new Image(filePath);

		// image view

		new ImageView(this.unflooded, this);

	}

}
