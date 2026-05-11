package ruly.lecture.ooka.practice.instance.c13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InventoryManagerTest {
	private final InventoryManager manager = new InventoryManager();

	@ParameterizedTest
	@DisplayName("在庫判定：注文数と在庫数の境界値")
	@CsvSource({
			"10, 9,  true", // 在庫に余裕あり
			"10, 10, true", // 在庫ぴったり（境界値）
			"10, 11, false", // 在庫不足（境界値+1）
			"0,  1,  false" // 在庫ゼロ
	})
	void testCanAllocate_Boundary(int stock, int orderQty, boolean expected) {
		Product p = new Product("商品A", stock);
		PurchaseOrder o = new PurchaseOrder(orderQty);
		assertEquals(expected, manager.canAllocate(p, o));
	}

	@Test
	@DisplayName("異常系：不正な注文数やnull入力")
	void testCanAllocate_Invalid() {
		// 注文数が0以下（仕様によりfalse）
		assertFalse(manager.canAllocate(new Product("A", 10), new PurchaseOrder(0)));
		assertFalse(manager.canAllocate(new Product("A", 10), new PurchaseOrder(-1)));
		// nullチェック
		assertFalse(manager.canAllocate(null, new PurchaseOrder(1)));
		assertFalse(manager.canAllocate(new Product("A", 10), null));
	}
}
