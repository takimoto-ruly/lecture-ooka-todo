package ruly.lecture.ooka.practice.oop.o05_strategy.expert.o05_11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("自動倉庫出荷・多階層システムの網羅テスト")
class DeliverySystemTest {

	@Test
	@DisplayName("正常系：複数Strategyの連携と親・子・孫クラスの多態的出荷費用検証")
	void testShippingAndStrategies() {
		InventoryAllocationStrategy picking = new SingleAllocation();
		PackagingCostStrategy packaging = new AreaPakagingCostStrategy();

		List<Integer> inventory = Arrays.asList(3, 12, 25); // 各倉庫の在庫数

		// 1. 在庫引当Strategy（ループ構文を含む実装）の個別検証
		assertTrue(picking.allocation(10, inventory), "12個の倉庫、25個の倉庫があるため引き当て可能");
		assertFalse(picking.allocation(30, inventory), "単独で30個を満たせる倉庫はないため引き当て不可");

		// 2. 梱包費Strategy（条件分岐構文を含む実装）の検証
		assertEquals(3000, packaging.calculateCost(20000, "離島"), "2万円の離島は3000円");
		assertEquals(0, packaging.calculateCost(60000, "離島"), "5万円以上は離島でも0円");
		assertEquals(500, packaging.calculateCost(20000, "東京"), "通常地域は500円");

		// 3. 多階層（親・子・孫）のインスタンスメソッド多態性検証（基本価格20000、離島宛て = 梱包費3000円）
		// 親（商品ベース）: 20000 + 3000 = 23000
		Product parent = new Product("一般本", 20000, picking, packaging);
		assertEquals(23000, parent.calculateTotalShippingCost("離島"));

		// 子（精密機器）: 親23000 + 保険料1500 = 24500
		Product child = new PrecisionProduct("パソコン", 20000, picking, packaging);
		assertEquals(24500, child.calculateTotalShippingCost("離島"));

		// 孫（スマートフォン）: 子24500 + 手数料800 = 25300
		Product grandchild = new SmartPhone("Galaxy", 20000, picking, packaging);
		assertEquals(25300, grandchild.calculateTotalShippingCost("離島"));
	}

	@Test
	@DisplayName("異常系：負の価格が入力された場合の防衛バリデーション検証")
	void testInvalidPriceException() {
		PackagingCostStrategy packaging = new AreaPakagingCostStrategy();
		assertThrows(IllegalArgumentException.class, () -> packaging.calculateCost(-100, "東京"));
	}
}
