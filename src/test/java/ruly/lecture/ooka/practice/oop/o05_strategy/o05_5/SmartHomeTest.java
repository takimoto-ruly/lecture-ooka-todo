package ruly.lecture.ooka.practice.oop.o05_strategy.o05_5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("スマート家電省エネシステムの包括テスト")
class SmartHomeTest {

	@Test
	@DisplayName("Strategyパターン：通常モードと省エネモードの切り替え検証")
	void testModeStrategy() {
		AirConditioner ac = new AirConditioner("リビングエアコン", new NormalMode());
		// 通常：1000
		assertEquals(1000, ac.calculatePowerConsumption());

		// 省エネ：1000 * 0.5 = 500
		ac.setActionModeStrategy(new LowPowerMode());
		assertEquals(500, ac.calculatePowerConsumption());
	}

	@Test
	@DisplayName("多態性：異なる家電のリストから一括で現在の消費電力を集計できるか")
	void testPolymorphicPowerSum() {
		ActionModeStrategy savingMode = new LowPowerMode();

		// すべて省エネモードで家電をリスト化（多態性）
		List<HomeAppliance> appliances = Arrays.asList(
				new AirConditioner("エアコン", savingMode), // 1000 * 0.5 = 500
				new Lighting("ライト", savingMode) // 100 * 0.5 = 50
		);

		int totalPower = 0;
		for (HomeAppliance appliance : appliances) {
			totalPower += appliance.calculatePowerConsumption(); // 多態性による呼び出し
		}

		assertEquals(550, totalPower, "省エネモード時の一括集計電力が正しくありません");
	}
}
