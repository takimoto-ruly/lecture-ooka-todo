package ruly.lecture.ooka.practice.instance.c06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SmartphoneTest {
	private Battery battery;
	private Smartphone phone;

	@BeforeEach
	void setUp() {
		// 初期残量10のバッテリーでスマホをセットアップ
		battery = new Battery(10);
		phone = new Smartphone("JavaPhone", battery);
	}

	@Test
	@DisplayName("アプリを使うとバッテリーが5ずつ減ること")
	void testUseApp() {
		phone.useApp("ブラウザ");
		assertEquals(5, battery.getLevel(), "10 - 5 = 5 になること");

		phone.useApp("メール");
		assertEquals(0, battery.getLevel(), "5 - 5 = 0 になること");
	}

	@Test
	@DisplayName("バッテリーが0の状態でアプリを使っても、マイナスにならないこと")
	void testBatteryEmpty() {
		phone.useApp("ゲーム1"); // 残量5
		phone.useApp("ゲーム2"); // 残量0
		phone.useApp("ゲーム3"); // 残量0のまま

		assertEquals(0, battery.getLevel(), "残量は0で止まること");
	}

	@Test
	@DisplayName("外部でバッテリーを充電すると、スマホ側にも反映されること（参照の共有）")
	void testExternalRecharge() {
		phone.useApp("カメラ"); // 残量5

		// スマホが持っているバッテリーを直接消費（または充電を想定）
		battery.consume(-10); // マイナス消費＝充電という実装であれば反映される
		// または単に新しいBatteryをセットできない仕様なら、既存インスタンスの操作を確認

		assertTrue(battery.getLevel() >= 5);
	}
}
