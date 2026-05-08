package ruly.lecture.ooka.practice.instance.c10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HomeAutomationTest {
	private final HomeAutomation auto = new HomeAutomation();

	@ParameterizedTest
	@DisplayName("冷房が必要な温度差の判定（同値クラス・境界値）")
	@CsvSource({
			"26.9, 25.0, false", // 1.9度差（境界値-0.1）
			"27.0, 25.0, true", // 2.0度差（境界値）
			"28.0, 25.0, true" // 3.0度差（同値クラス：有効）
	})
	void testNeedsCooling_Temperature(double current, double setting, boolean expected) {
		TemperatureSensor s = new TemperatureSensor(current);
		AirConditioner ac = new AirConditioner(true, setting);
		assertEquals(expected, auto.needsCooling(s, ac));
	}

	@Test
	@DisplayName("異常系：電源OFFやnullの場合")
	void testNeedsCooling_OffAndNull() {
		// 電源OFF（温度条件を満たしていても不可）
		assertFalse(auto.needsCooling(new TemperatureSensor(30.0), new AirConditioner(false, 25.0)));
		// nullチェック
		assertFalse(auto.needsCooling(null, new AirConditioner(true, 25.0)));
		assertFalse(auto.needsCooling(new TemperatureSensor(30.0), null));
	}
}
