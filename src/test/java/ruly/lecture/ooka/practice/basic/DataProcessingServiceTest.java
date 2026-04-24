package ruly.lecture.ooka.practice.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DataProcessingServiceTest {

	private final DataProcessingService service = new DataProcessingService();

	@Test
	@DisplayName("正常系：数値、文字列、負の数が混在する場合でも正しく集計されること")
	void testProcessData_MixedInputs() {
		String[] inputs = { "10", "abc", "-5", "25", "0", "5" };
		// 合計: 10 + 25 + 5 = 40
		// 最大: 25
		int[] result = service.processData(inputs);

		assertArrayEquals(new int[] { 40, 25 }, result, "集計値が正しくありません");
	}

	@Test
	@DisplayName("境界値：有効な数値が一つもない場合、[0, 0]が返ること")
	void testProcessData_NoValidInputs() {
		String[] inputs = { "abc", "-1", "xyz" };
		int[] result = service.processData(inputs);

		assertArrayEquals(new int[] { 0, 0 }, result);
	}

	@Test
	@DisplayName("異常系：入力配列がnullの場合、nullが返ること")
	void testProcessData_NullInput() {
		assertNull(service.processData(null), "null入力時はnullを返すべきです");
	}

	@Test
	@DisplayName("境界値：配列が空の場合、[0, 0]が返ること")
	void testProcessData_EmptyInput() {
		int[] result = service.processData(new String[] {});
		assertArrayEquals(new int[] { 0, 0 }, result);
	}
}
