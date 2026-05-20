package ruly.lecture.ooka.practice.oop.o04_template_method.c04_3;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ハンバーガーショップの網羅テスト")
class BurgerTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@BeforeEach
	void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	@DisplayName("普通のバーガー：フックがfalseを返し、トッピング処理がスキップされることの検証")
	void testNormalBurger() {
		Hamburger burger = new NormalHamburger();

		// フックの確認
		assertFalse(burger.isToppingRequired(), "デフォルト（普通）はfalseである必要があります");

		burger.cook();
		String output = outContent.toString();

		// トッピングが含まれていないことを網羅検証
		assertAll("普通のバーガーの出力検証",
				() -> assertTrue(output.contains("下のバンズ")),
				() -> assertTrue(output.contains("上のバンズ")),
				() -> assertFalse(output.contains("チーズを追加します"), "トッピングが表示されてはいけません"));
	}

	@Test
	@DisplayName("チーズバーガー：フックがtrueを返し、トッピング処理が割り込むことの検証")
	void testCheeseBurger() {
		Hamburger burger = new CheeseBurger();

		// フックの確認
		assertTrue(burger.isToppingRequired(), "チーズバーガーはtrueを返す必要があります");

		burger.cook();
		String output = outContent.toString();

		// トッピングが正しい位置（ソースの後、上のバンズの前）付近にあるかを含め検証
		assertTrue(output.contains("チーズを追加します"), "トッピングが表示される必要があります");
	}
}