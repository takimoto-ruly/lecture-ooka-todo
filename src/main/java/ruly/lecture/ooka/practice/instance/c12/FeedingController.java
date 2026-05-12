package ruly.lecture.ooka.practice.instance.c12;

/**
 * 給餌の判定を行う制御クラスです。
 * 
 * <p>
 * 【設計仕様】
 * </p>
 * <ul>
 * <li>メソッド名: shouldFeed</li>
 * <li>戻り値: boolean</li>
 * <li>引数: Pet pet, FoodDispenser dispenser</li>
 * <li>判定ロジック:
 * <ul>
 * <li>引数のいずれかが null の場合は false を返す。</li>
 * <li>ペットが病気(isSick)の場合は常に false。</li>
 * <li>経過時間が 6時間以上 かつ 餌箱の残量が 10g以上 の場合に true。</li>
 * </ul>
 * </li>
 * </ul>
 */
public class FeedingController {

	public boolean shouldFeed(Pet pet, FoodDispenser dispenser) {
		if (pet == null || dispenser == null || pet.isSick()) {
			return false;
		}

		if (pet.getHoursSinceLastMeal() >= 6 && dispenser.getRemainingAmount() >= 10) {
			return true;
		}

		return false;
	}
}
