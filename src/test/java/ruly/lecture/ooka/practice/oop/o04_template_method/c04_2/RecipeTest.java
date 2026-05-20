package ruly.lecture.ooka.practice.oop.o04_template_method.c04_2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("料理レシピの網羅テスト")
class RecipeTest {

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
	@DisplayName("カレー職人：味付け文字列の取得および全体の調理フローの網羅検証")
	void testCurryRecipe() {
		CookingRecipe curry = new CurryCook();

		// 1. 子クラスの個別メソッド検証
		assertEquals("カレールーを投入", curry.getSpice(), "味付け文字列が正しくありません");

		// 2. 全体の出力フロー検証
		curry.cook();
		String expected = "材料を切りました。" + System.lineSeparator() +
				"炒めました。" + System.lineSeparator() +
				"カレールーを投入をして完成です！" + System.lineSeparator();

		assertEquals(expected, outContent.toString());
	}

	@Test
	@DisplayName("チャーハン職人：味付け文字列の取得および全体の調理フローの網羅検証")
	void testFriedRiceRecipe() {
		CookingRecipe rice = new FriedriceCook();

		// 1. 子クラスの個別メソッド検証
		assertEquals("塩コショウを少々", rice.getSpice(), "味付け文字列が正しくありません");

		// 2. 全体の出力フロー検証
		rice.cook();
		String expected = "材料を切りました。" + System.lineSeparator() +
				"炒めました。" + System.lineSeparator() +
				"塩コショウを少々をして完成です！" + System.lineSeparator();

		assertEquals(expected, outContent.toString());
	}
}
