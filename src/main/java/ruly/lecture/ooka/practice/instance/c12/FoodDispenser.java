package ruly.lecture.ooka.practice.instance.c12;

import lombok.Getter;

/**
 * 餌箱の状態を保持するクラスです。 <br>
 * フィールド: int remainingAmount コンストラクタ: 全フィールドを初期化
 */
@Getter
public class FoodDispenser {

	private int remainingAmount;

	public FoodDispenser(int remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
}
