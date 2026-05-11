package ruly.lecture.ooka.practice.instance.c12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FeedingControllerTest {
	private final FeedingController controller = new FeedingController();

	@ParameterizedTest
	@DisplayName("給餌判定：時間と残量の境界値・同値クラス")
	@CsvSource({
			"5, 10, false", // 時間不足（境界値-1）
			"6, 10, true", // 時間境界・残量境界（境界値）
			"7, 11, true", // 条件超過（同値クラス：有効）
			"6, 9,  false" // 残量不足（境界値-1）
	})
	void testShouldFeed_Normal(int hours, int amount, boolean expected) {
		Pet pet = new Pet(hours, false);
		FoodDispenser dispenser = new FoodDispenser(amount);
		assertEquals(expected, controller.shouldFeed(pet, dispenser));
	}

	@Test
	@DisplayName("異常系：病気の場合やnull入力のハンドリング")
	void testShouldFeed_Abnormal() {
		// 病気の場合は条件を満たしていても不可
		assertFalse(controller.shouldFeed(new Pet(10, true), new FoodDispenser(20)));
		// nullチェック
		assertFalse(controller.shouldFeed(null, new FoodDispenser(10)));
		assertFalse(controller.shouldFeed(new Pet(6, false), null));
	}
}
