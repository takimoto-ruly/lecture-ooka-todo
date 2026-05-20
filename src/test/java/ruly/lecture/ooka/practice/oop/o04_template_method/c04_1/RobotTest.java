package ruly.lecture.ooka.practice.oop.o04_template_method.c04_1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("挨拶ロボットの網羅テスト")
class RobotTest {

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
	@DisplayName("日本語ロボット：開始・固有挨拶・終了の順序と改行コードの網羅検証")
	void testJapaneseRobotBehavior() {
		Robot robot = new Japanese();
		robot.startBehavior();

		// 期待される出力（OS依存の改行コードに対応）
		String expected = "ロボットの電源を入れます。" + System.lineSeparator() +
				"こんにちは！" + System.lineSeparator() +
				"ロボットの電源を切ります。" + System.lineSeparator();

		assertEquals(expected, outContent.toString(), "処理フローの順序および出力内容が一致していません");
	}

	@Test
	@DisplayName("英語ロボット：開始・固有挨拶・終了の順序と改行コードの網羅検証")
	void testEnglishRobotBehavior() {
		Robot robot = new English();
		robot.startBehavior();

		String expected = "ロボットの電源を入れます。" + System.lineSeparator() +
				"Hello!" + System.lineSeparator() +
				"ロボットの電源を切ります。" + System.lineSeparator();

		assertEquals(expected, outContent.toString(), "処理フローの順序および出力内容が一致していません");
	}
}
