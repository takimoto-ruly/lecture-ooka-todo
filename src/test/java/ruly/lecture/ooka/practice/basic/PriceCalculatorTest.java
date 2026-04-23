package ruly.lecture.ooka.practice.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PriceCalculatorTest {
	private final PriceCalculator calculator = new PriceCalculator();

	@ParameterizedTest
	@DisplayName("合計金額に応じた割引適用後の金額が正しく計算されること")
	@CsvSource({
			"4999, 4999", // 割引なし境界
			"5000, 4500", // 500円引き開始
			"9999, 9499", // 500円引き境界
			"10000, 9000", // 1000円引き開始
			"15000, 14000", // 1000円引き適用
			"0, 0" // 0円の場合
	})
	void testCalculateDiscountedPrice(int totalAmount, int expected) {
		assertEquals(expected, calculator.calculateDiscountedPrice(totalAmount));
	}
}
