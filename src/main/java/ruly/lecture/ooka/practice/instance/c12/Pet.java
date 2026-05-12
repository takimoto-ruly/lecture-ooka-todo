package ruly.lecture.ooka.practice.instance.c12;

import lombok.Getter;

/**
 * ペットの状態を保持するクラスです。<br>
 * フィールド: int hoursSinceLastMeal, boolean isSick<br>
 * コンストラクタ: 全フィールドを初期化
 */
@Getter
public class Pet {
	private int hoursSinceLastMeal;
	private boolean isSick;

	public Pet(int hoursSinceLastMeal, boolean isSick) {
		this.hoursSinceLastMeal = hoursSinceLastMeal;
		this.isSick = isSick;
	}
}
