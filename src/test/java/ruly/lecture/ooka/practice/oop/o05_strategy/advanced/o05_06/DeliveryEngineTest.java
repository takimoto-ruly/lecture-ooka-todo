package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題1: 多階層配送料計算エンジンの網羅テスト")
class DeliveryEngineTest {

	@Test
	@DisplayName("正常系：親・子・孫クラスにおけるエコノミー/プレミアム戦略の多態的計算検証")
	void testMultiLayerShipping() {
		DeliveryStrategy economy = new EconomyDelivery();
		DeliveryStrategy premium = new PremiumDelivery();

		// 1. 親クラス単体の検証 (重量 10.0kg)
		ParcelBase parent = new ParcelBase("TRK-001", 10.0);
		assertEquals(1500, parent.calculateCost(economy)); // 10.0 * 150 = 1500
		assertEquals(7000, parent.calculateCost(premium)); // 10.0 * 500 + 2000 = 7000

		// 2. 子クラス（クール冷凍便）の検証 (親の計算 + 1200円)
		ParcelBase child = new CoolDelivery("TRK-002", 10.0);
		assertEquals(2700, child.calculateCost(economy)); // 1500 + 1200 = 2700

		// 3. 孫クラス（クール冷凍便・離島宛て）の検証 ((子の計算) * 1.5倍)
		ParcelBase grandchild = new IslandCoolDelivery("TRK-003", 10.0);
		// エコノミー: (1500 + 1200) * 1.5 = 4050
		assertEquals(4050, grandchild.calculateCost(economy));
		// プレミアム: (7000 + 1200) * 1.5 = 12300
		assertEquals(12300, grandchild.calculateCost(premium));
	}

	@Test
	@DisplayName("異常系：重量に0以下の不正な値を渡した際、適切に例外がスローされるか")
	void testInvalidWeightException() {
		DeliveryStrategy economy = new EconomyDelivery();
		assertThrows(IllegalArgumentException.class, () -> economy.calculateFee(0.0));
		assertThrows(IllegalArgumentException.class, () -> economy.calculateFee(-5.5));
	}
}