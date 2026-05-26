package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("スマートホームマルチレイヤー電力制御の網羅テスト")
class SmartHomePowerTest {

	@Test
	@DisplayName("正常系：孫クラス（床暖房空調）における、床暖房のオン/オフ状態に伴う多階層集計の検証")
	void testMultiLayerPowerConsumption() {
		OperatingModeStrategy saving = new SavingMode();
		OperatingModeStrategy boost = new BoostMode();

		// 基準電力 1000W
		// 1. 親クラス：1000 * 0.6 = 600W
		HomeAppliance base = new HomeAppliance("基本家電", 1000);
		assertEquals(600, base.powerConsumption(saving));

		// 2. 子クラス（空調）：(1000 * 0.6) + 固定200 = 800W
		HomeAppliance ac = new AirConditioner("標準エアコン", 1000);
		assertEquals(800, ac.powerConsumption(saving));

		// 3. 孫クラス（床暖房連動空調）
		PremiumAirConditioner premiumAc = new PremiumAirConditioner("最高級空調", 1000);

		// 床暖房オフ状態：子クラスと同じ結果になるべき (800W)
		premiumAc.setFloorHeaterIsRunning(false);
		assertEquals(800, premiumAc.powerConsumption(saving));

		// 床暖房オン状態：さらに +500W されるべき (800 + 500 = 1300W)
		premiumAc.setFloorHeaterIsRunning(true);
		assertEquals(1300, premiumAc.powerConsumption(saving));

		// ブーストモード時の床暖房オン：(1000 * 1.5) + 200 + 500 = 2200W
		assertEquals(2200, premiumAc.powerConsumption(boost));
	}
}
