package ruly.lecture.ooka.practice.instance.c09;

/**
 * 部屋情報のDTOです。<br>
 * フィールド: String roomName, int requiredLevel<br>
 * コンストラクタ: 全フィールドを初期化
 */
public class Room {

	private String roomName;
	private int requiredLevel;

	public Room(String roomName, int requiredLevel) {
		this.roomName = roomName;
		this.requiredLevel = requiredLevel;
	}

	public int getRequiredLevel() {
		return this.requiredLevel;
	}
}
