package ruly.lecture.ooka.practice.instance.c09;

/**
 * 利用者カード情報のDTOです。<br>
 * フィールド: String userName, int securityLevel, boolean isExpired<br>
 * コンストラクタ: 全フィールドを初期化
 */
public class UserCard {

	private String userName;
	private int sequrityLevel;
	private static boolean isExpired;

	public UserCard(String userName, int sequrityLevel, boolean isExpired) {
		this.userName = userName;
		this.sequrityLevel = sequrityLevel;
		this.isExpired = isExpired;
	}

	public boolean getIsExpired() {
		return isExpired;
	}

	public int getSequrityLevel() {
		return sequrityLevel;
	}
}
