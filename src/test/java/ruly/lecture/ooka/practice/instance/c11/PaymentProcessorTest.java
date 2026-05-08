package ruly.lecture.ooka.practice.instance.c11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PaymentProcessorTest {
	private final PaymentProcessor processor = new PaymentProcessor();

	@ParameterizedTest
	@DisplayName("ポイント決済の残高判定（同値クラス・境界値）")
	@CsvSource({
			"1000, 999,  false", // ポイント不足（境界値-1）
			"1000, 1000, true", // ぴったり（境界値）
			"1000, 1500, true" // 余裕あり（同値クラス：有効）
	})
	void testCanPay_PointBalance(int amount, int balance, boolean expected) {
		assertEquals(expected, processor.canPayWithPoints(new Order(amount), new UserCard(balance, false)));
	}

	@Test
	@DisplayName("異常系：期限切れカードやnullの場合")
	void testCanPay_ExpiredAndNull() {
		// 期限切れ
		assertFalse(processor.canPayWithPoints(new Order(100), new UserCard(500, true)));
		// nullチェック
		assertFalse(processor.canPayWithPoints(null, new UserCard(500, false)));
		assertFalse(processor.canPayWithPoints(new Order(100), null));
	}
}
