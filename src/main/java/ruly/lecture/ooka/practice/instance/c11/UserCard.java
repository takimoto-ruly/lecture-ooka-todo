package ruly.lecture.ooka.practice.instance.c11;

import lombok.Getter;

/**
 * ユーザーのカード情報を保持するデータクラスです。
 * 
 * <p>
 * 【設計仕様】
 * </p>
 * <ul>
 * <li>フィールド1: int pointBalance (保有ポイント)</li>
 * <li>フィールド2: boolean isExpired (期限切れかどうか)</li>
 * <li>コンストラクタ: 全てのフィールドを初期化するコンストラクタを定義すること</li>
 * </ul>
 */
public class UserCard {
	@Getter
	private int pointBalance;
	private boolean isExpired;

	public UserCard(int pointBalance, boolean isExpiread) {
		this.pointBalance = pointBalance;
		this.isExpired = isExpiread;
	}

	public boolean isExpired() {
		return isExpired;
	}
}
