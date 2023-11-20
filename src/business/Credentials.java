package business;

import utils.Enums.RearrangeTypeEnum;
import utils.Vector2;

public enum Credentials {

	INSTANCE;

	public String primaryStageTitle = "Forbidden Island", numbersImageViewColor = "black";
	public boolean colliderVisibility = true;
	public double stagePixesOnTheLeft = 180, gapBetweenBorders = 25, textHeight = 50,
			selectEventHandlerAbleDimension = 100, animationStep = 4, cameraViewSpots = 1;
	public Vector2 dFrame, dGapBetweenComponents, dCameraView, dGapBetweenComponentsLineCast;
	public Vector2 cTextPanel, cImageViewClone;
	public RearrangeTypeEnum rearrangeTypeEnumText = RearrangeTypeEnum.LINEAR;

	public Vector2 dTile;
	public Vector2 cBoardPosition;

	private Credentials() {

		double x = 0, y = 0;

		// frame

		this.dFrame = new Vector2(2560 - 4 - 636, 1368 - 2);

		// gaps

		this.dGapBetweenComponents = new Vector2(4, 4);
		this.dGapBetweenComponentsLineCast = this.dGapBetweenComponents;

		// camera view

		this.dCameraView = new Vector2(1, 1);

		// c text panel

		x = 0;
		y = 0;

		this.cTextPanel = new Vector2(x, y);

		// c image view indicator

		x = this.gapBetweenBorders;
		y = this.gapBetweenBorders;
		this.cImageViewClone = new Vector2(x, y);

		// d tile

		x = 216;
		this.dTile = new Vector2(x, x);

		// c board position

		x = this.gapBetweenBorders;
		x += this.dTile.x / 2;
		this.cBoardPosition = new Vector2(x, x);

	}

}
