package ruly.lecture.ooka.practice.instance.c11;

import lombok.Getter;

/**
 * 注文内容を保持するデータクラスです。
 * 
 * <p>
 * 【設計仕様】
 * </p>
 * <ul>
 * <li>フィールド1: int totalAmount (合計金額)</li>
 * <li>コンストラクタ: フィールドを初期化するコンストラクタを定義すること</li>
 * </ul>
 */
public class Order {

	@Getter
	private int totalAmount;

	public Order(int totalAmount) {
		this.totalAmount = totalAmount;
	}

}
