package enums;

import utils.Enums.TextTypeEnum;
import utils.TextManager;

public enum EText {

	CANCEL("Cancel", TextTypeEnum.OPTION),
	CONTINUE("Continue", TextTypeEnum.OPTION),
	RESTART("Restart", TextTypeEnum.OPTION),
	START_GAME("Start game", TextTypeEnum.OPTION),
	VOID("", TextTypeEnum.INDICATOR),
	YOU_LOST("You lost", TextTypeEnum.INDICATOR),
	YOU_WON("You won", TextTypeEnum.INDICATOR),
	ACTION("Action ", TextTypeEnum.INDICATOR),
	MOVE("Move", TextTypeEnum.OPTION),
	SHORE_UP("Shore up", TextTypeEnum.OPTION),
	GIVE_TREASURE_CARD("Pass treasure card", TextTypeEnum.OPTION),
	CAPTURE_TREASURE("Capture treasure", TextTypeEnum.OPTION),
	END_TURN("End turn", TextTypeEnum.OPTION),

	;

	private TextTypeEnum textTypeEnum = null;
	private String string = null;

	private EText(String string, TextTypeEnum textTypeEnum) {

		this.string = string;
		this.textTypeEnum = textTypeEnum;

	}

	public void show() {
		TextManager.INSTANCE.showText(this, getString());
	}

	public void showAdditionally(String string) {
		TextManager.INSTANCE.showText(this, getString() + string);
	}

	public void showAdditionally(int integer) {
		showAdditionally(Integer.toString(integer));
	}

	public void showInstead(String string) {
		TextManager.INSTANCE.showText(this, string);
	}

	public String getString() {
		return this.string;
	}

	public TextTypeEnum getTextTypeEnum() {
		return this.textTypeEnum;
	}

}
