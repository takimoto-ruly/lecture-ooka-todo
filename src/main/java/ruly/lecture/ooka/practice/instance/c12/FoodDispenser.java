package ruly.lecture.ooka.practice.instance.c12;

/**
 * 餌箱の状態を保持するクラスです。 <br>
 * フィールド: int remainingAmount コンストラクタ: 全フィールドを初期化
 */
public class FoodDispenser {

	private int remainingAmount;

	public FoodDispenser(int remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public int getRemainingAmount() {
		return this.remainingAmount;
	}

}
