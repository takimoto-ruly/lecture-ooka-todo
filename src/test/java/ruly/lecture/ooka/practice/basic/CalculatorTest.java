package ruly.lecture.ooka.practice.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
	private final Calculator calc = new Calculator();

	@ParameterizedTest
	@DisplayName("1からnまでの合計が正しく計算されること")
	@CsvSource({
		"5, 15", // 1+2+3+4+5 = 15
		"10, 55", // 1から10までの合計は55
		"1, 1", // 境界値：1の場合は1
		"0, 0", // 境界値：0の場合は0
		"-5, 0" // 負の数の場合は0
	})
	void testSumUp(int max, int expected) {
		assertEquals(expected, calc.sumUp(max));
	}
}
