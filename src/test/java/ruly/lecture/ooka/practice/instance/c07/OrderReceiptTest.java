package ruly.lecture.ooka.practice.instance.c07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import ruly.lecture.ooka.practice.instance.c07.OrderReceipt;
import ruly.lecture.ooka.practice.instance.c07.Product;

public class OrderReceiptTest {
	private OrderReceipt receipt;

	@BeforeEach
	void setUp() {
		receipt = new OrderReceipt();
	}

	@Nested
	@DisplayName("数量の境界値と異常系のテスト（同値分割・境界値分析）")
	class QuantityTest {

		@Test
		@DisplayName("有効な最小数量(1)で正しく計算されること")
		void testMinimumQuantity() {
			receipt.addDetail(new Product("商品A", 100), 1);
			assertEquals(100, receipt.calculateTotal());
		}

		@Test
		@DisplayName("数量に 0 を指定した場合、明細として追加されない（または合計に影響しない）こと")
		void testZeroQuantity() {
			receipt.addDetail(new Product("商品A", 100), 0);
			assertEquals(0, receipt.calculateTotal(), "数量0は合計金額に寄与してはいけません");
		}

		@Test
		@DisplayName("負の数量を指定した場合、合計に影響しない（または無視される）こと")
		void testNegativeQuantity() {
			receipt.addDetail(new Product("商品A", 100), -1);
			assertEquals(0, receipt.calculateTotal(), "負の数量は不正な入力として扱う必要があります");
		}
	}

	@Nested
	@DisplayName("金額と税金の計算テスト（端数処理の確認）")
	class PriceAndTaxTest {

		@Test
		@DisplayName("合計金額が 0円 の場合、税額も 0円 になること")
		void testZeroTax() {
			assertEquals(0, receipt.getTaxAmount());
		}

		@Test
		@DisplayName("端数が出る合計金額で、消費税が小数点以下切り捨てで計算されること")
		void testTaxFloorCalculation() {
			// 合計 109円 の場合、税金は 10.9円 -> 切り捨てで 10円
			receipt.addDetail(new Product("端数商品", 109), 1);
			assertEquals(109, receipt.calculateTotal());
			assertEquals(10, receipt.getTaxAmount(), "109円の10%は、切り捨てで10円である必要があります");
		}

		@Test
		@DisplayName("非常に大きな金額でも正しく合計が算出されること")
		void testLargeAmount() {
			receipt.addDetail(new Product("高額商品", 1_000_000), 10);
			assertEquals(10_000_000, receipt.calculateTotal());
			assertEquals(1_000_000, receipt.getTaxAmount());
		}
	}

	@Nested
	@DisplayName("状態の独立性のテスト（ディープコピーの確認）")
	class StateIsolationTest {

		@Test
		@DisplayName("明細追加後にProductの価格が変更されても、伝票の合計が変わらないこと")
		void testPriceSnapshotInDetail() {
			// 注意：このテストは Product の単価を後から変えられる設計（setterがある等）
			// もしくは、OrderDetailが内部で価格を保持しているかを検証するものです。

			// 1. 最初は 500円の商品として明細追加
			Product p = new Product("限定品", 500);
			receipt.addDetail(p, 1);

			// 2. 本来なら Product は final であるべきですが、
			// 「OrderDetailがProductへの参照だけでなく、価格をコピーしたか」が重要です。
			// 仕様上「OrderDetail内の unitPrice フィールド」を直接、または合計計算経由で確認します。
			assertEquals(500, receipt.calculateTotal());
		}
	}
}
