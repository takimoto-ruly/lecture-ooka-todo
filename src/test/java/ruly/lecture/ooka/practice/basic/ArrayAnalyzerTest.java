package ruly.lecture.ooka.practice.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayAnalyzerTest {
	private final ArrayAnalyzer analyzer = new ArrayAnalyzer();

	@Test
	@DisplayName("正の整数を含む配列から最大値が取得できること")
	void testFindMaxWithPositive() {
		int[] nums = { 1, 10, 5, 8 };
		assertEquals(10, analyzer.findMax(nums));
	}

	@Test
	@DisplayName("負の整数のみの配列から最大値が取得できること")
	void testFindMaxWithNegative() {
		int[] nums = { -5, -2, -10 };
		assertEquals(-2, analyzer.findMax(nums));
	}

	@Test
	@DisplayName("要素が1つだけの配列はその値が最大値となること")
	void testFindMaxWithSingleElement() {
		int[] nums = { 7 };
		assertEquals(7, analyzer.findMax(nums));
	}

	@Test
	@DisplayName("空の配列が渡された場合は0を返すこと")
	void testFindMaxWithEmptyArray() {
		int[] nums = {};
		assertEquals(0, analyzer.findMax(nums));
	}
}
