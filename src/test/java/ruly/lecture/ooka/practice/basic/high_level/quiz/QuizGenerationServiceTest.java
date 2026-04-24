package ruly.lecture.ooka.practice.basic.high_level.quiz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class QuizGenerationServiceTest {

	private final QuizGenerationService service = new QuizGenerationService();

	@Nested
	@DisplayName("難易度のバリデーションと境界値テスト")
	class DifficultyValidation {

		@ParameterizedTest
		@ValueSource(ints = { 1, 2, 3 })
		@DisplayName("有効な難易度(1,2,3)で例外が発生しないこと")
		void testValidDifficulty(int difficulty) {
			assertDoesNotThrow(() -> service.generateQuestion(CalcMode.ADD, difficulty));
		}

		@ParameterizedTest
		@ValueSource(ints = { 0, 4 })
		@DisplayName("境界外の難易度(0, 4)でIllegalArgumentExceptionが発生すること")
		void testInvalidDifficultyBoundary(int difficulty) {
			assertThrows(IllegalArgumentException.class, () -> service.generateQuestion(CalcMode.ADD, difficulty));
		}
	}

	@Nested
	@DisplayName("数値生成範囲のテスト（同値分割）")
	class RangeTesting {

		@Test
		@DisplayName("難易度1の場合、生成される数値が1から9の範囲内であること")
		void testDifficulty1Range() {
			for (int i = 0; i < 100; i++) {
				QuizDTO quiz = service.generateQuestion(CalcMode.ADD, 1);
				assertTrue(quiz.getNum1() >= 1 && quiz.getNum1() <= 9);
				assertTrue(quiz.getNum2() >= 1 && quiz.getNum2() <= 9);
			}
		}

		@Test
		@DisplayName("難易度3の場合、生成される数値が100から999の範囲内であること")
		void testDifficulty3Range() {
			QuizDTO quiz = service.generateQuestion(CalcMode.ADD, 3);
			assertTrue(quiz.getNum1() >= 100 && quiz.getNum1() <= 999);
		}
	}

	@Nested
	@DisplayName("各モードの特殊制約テスト")
	class ModeConstraintTesting {

		@Test
		@DisplayName("引き算(SUBTRACT)にて、num1がnum2より小さい場合は入れ替えが発生し、答えが負にならないこと")
		void testSubtractExchangeLogic() {
			for (int i = 0; i < 100; i++) {
				QuizDTO quiz = service.generateQuestion(CalcMode.SUBTRACT, 1);
				assertTrue(quiz.getNum1() >= quiz.getNum2(), "num1 < num2 になっています");
			}
		}

		@Test
		@DisplayName("割り算(DIVISION)にて、余りが必ず0になり、かつ割る数が0でないこと")
		void testDivisionLogic() {
			for (int i = 0; i < 100; i++) {
				QuizDTO quiz = service.generateQuestion(CalcMode.DIVISION, 2);
				assertNotEquals(0, quiz.getNum2(), "割る数が0になっています");
				assertEquals(0, quiz.getNum1() % quiz.getNum2(), "割り切れない問題が生成されました");
			}
		}
	}
}
