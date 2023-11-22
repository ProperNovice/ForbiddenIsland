package business;

import utils.Enums.RearrangeTypeEnum;
import utils.Vector2;

public enum Credentials {

	INSTANCE;

	public String primaryStageTitle = "Forbidden Island", numbersImageViewColor = "black";
	public boolean colliderVisibility = true;
	public double stagePixesOnTheLeft = 180 + 95, gapBetweenBorders = 25, textHeight = 50,
			selectEventHandlerAbleDimension = 100, animationStep = 4, cameraViewSpots = 1;
	public Vector2 dFrame, dGapBetweenComponents, dCameraView, dGapBetweenComponentsLineCast;
	public Vector2 cTextPanel, cImageViewClone;
	public RearrangeTypeEnum rearrangeTypeEnumText = RearrangeTypeEnum.LINEAR;

	public double tileActionPercentage = 2;
	public Vector2 dTile, dCard, dAdventurerPawn;
	public Vector2 cBoardPosition, cDeckFlood, cDiscardPileFlood, cDeckTreasure,
			cDiscardPileTreasure, playerIAdventurerCard, playerIIAdventurerCard, playerICardTreasureList,
			playerIICardTreasureList;

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

		// d card

		x = 182;
		y = 260;
		this.dCard = new Vector2(x, y);

		// d adventurer pawn

		y = this.dTile.y / 2;
		x = 466 * y / 768;
		this.dAdventurerPawn = new Vector2(x, y);

		// d frame

		x = 2 * this.gapBetweenBorders;
		x -= 4;
		x += 6 * this.dTile.x;
		x += 4 * this.dCard.x;
		x += 9 * this.dGapBetweenComponents.x;
		this.dFrame.x = x;

		// c board position

		x = this.gapBetweenBorders;
		x += this.dTile.x / 2;
		this.cBoardPosition = new Vector2(x, x);

		// c deck flood

		x = this.gapBetweenBorders;
		x += 6 * this.dTile.x;
		x += 6 * this.dGapBetweenComponents.x;
		y = this.gapBetweenBorders;
		this.cDeckFlood = new Vector2(x, y);

		// c discard pile flood

		x = this.cDeckFlood.x;
		x += this.dCard.x;
		x += this.dGapBetweenComponents.x;
		this.cDiscardPileFlood = new Vector2(x, y);

		// c deck treasure

		x = this.cDiscardPileFlood.x;
		x += this.dCard.x;
		x += this.dGapBetweenComponents.x;
		this.cDeckTreasure = new Vector2(x, y);

		// c discard pile treasure

		x = this.cDeckTreasure.x;
		x += this.dCard.x;
		x += this.dGapBetweenComponents.x;
		this.cDiscardPileTreasure = new Vector2(x, y);

		// player I adventurer card

		x = this.cDeckFlood.x;
		y = this.cDeckFlood.y;
		y += this.dCard.y;
		y += this.dGapBetweenComponents.y;
		this.playerIAdventurerCard = new Vector2(x, y);

		// player I list

		x = this.playerIAdventurerCard.x;
		x += this.dCard.x;
		x += this.dGapBetweenComponents.x;
		y = this.playerIAdventurerCard.y;
		this.playerICardTreasureList = new Vector2(x, y);

		// player II adventurer card

		x = this.cDeckFlood.x;
		y = this.playerIAdventurerCard.y;
		y += this.dCard.y;
		y += this.dGapBetweenComponents.y;
		this.playerIIAdventurerCard = new Vector2(x, y);

		// player II list

		x = this.playerIIAdventurerCard.x;
		x += this.dCard.x;
		x += this.dGapBetweenComponents.x;
		y = this.playerIIAdventurerCard.y;
		this.playerIICardTreasureList = new Vector2(x, y);

	}

}
