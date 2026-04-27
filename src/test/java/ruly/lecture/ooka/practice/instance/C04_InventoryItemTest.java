package ruly.lecture.ooka.practice.instance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class C04_InventoryItemTest {
	@Test
	@DisplayName("商品情報がコンストラクタで正しく設定され、変更不可であること")
	void testItemInitialization() {
		C04_InventoryItem item = new C04_InventoryItem("ITEM-001", "ノートPC");

		assertEquals("ITEM-001", item.getItemId());
		assertEquals("ノートPC", item.getItemName());
		assertEquals(0, item.getQuantity(), "初期在庫は0である必要があります");
	}

	@Test
	@DisplayName("在庫の補充と出荷が正しく行われ、在庫不足時の出荷が阻止されること")
	void testStockFlow() {
		C04_InventoryItem item = new C04_InventoryItem("A", "Test");

		// 補充テスト
		item.restock(10);
		assertEquals(10, item.getQuantity());

		// 正常出荷
		boolean shipped = item.ship(3);
		assertTrue(shipped);
		assertEquals(7, item.getQuantity());

		// 過剰出荷の阻止
		boolean overShip = item.ship(10);
		assertFalse(overShip, "在庫以上の出荷は失敗する必要があります");
		assertEquals(7, item.getQuantity(), "出荷失敗時に在庫が減ってはいけません");
	}

	@Test
	@DisplayName("staticフィールドにより全インスタンスの累計出荷数が正しく集計されること")
	void testTotalShippedCount() {
		int startTotal = C04_InventoryItem.getTotalShippedCount();

		C04_InventoryItem item1 = new C04_InventoryItem("ID1", "Item1");
		C04_InventoryItem item2 = new C04_InventoryItem("ID2", "Item2");

		item1.restock(100);
		item2.restock(100);

		item1.ship(10); // 成功
		item2.ship(20); // 成功
		item1.ship(5); // 成功
		item2.ship(200); // 失敗（カウントしない）

		assertEquals(startTotal + 35, C04_InventoryItem.getTotalShippedCount(),
				"出荷に成功した累計数（10+20+5）が正しく加算されている必要があります");
	}
}
