package ruly.lecture.ooka.practice.oop.o05_strategy.o05_1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題1: ショップ決済システムの包括テスト")
class ShopPaymentTest {

	@Test
	@DisplayName("継承と子クラス固有の振る舞い（標準出力）が正しく機能するか")
	void testInheritanceAndUniqueBehavior() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		AppareelShop clothingShop = new AppareelShop("原宿店", new CashPayment());
		clothingShop.fitting(); // 固有メソッド

		assertEquals("試着しました" + System.lineSeparator(), outContent.toString());
		System.setOut(System.out); // ストリームの復元
	}

	@Test
	@DisplayName("Strategyパターン：決済方法の動的切り替えと多態性が機能するか")
	void testPaymentStrategySwitching() {
		// 親の型（Shop）の変数に子クラス（BookShop）を代入（多態性）
		Shop shop = new BookShop("新宿店", new CashPayment());

		// 1. 初期状態（現金決済）の検証
		assertEquals("3000円を現金で支払いました", shop.processPayment(3000));

		// 2. 途中でカード決済に切り替え（Strategy）
		shop.setPaymentMethod(new CardPayment());
		assertEquals("3000円をカードで支払いました（手数料0円）", shop.processPayment(3000));
	}
}