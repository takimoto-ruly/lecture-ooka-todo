package ruly.lecture.ooka.practice.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidatorTest {
	private final Validator validator = new Validator();

	@ParameterizedTest
	@DisplayName("パスワードのバリデーション仕様に基づき正しく判定されること")
	@CsvSource({ "A1234567, true", // ちょうど8文字
			"Z123456789012345, true", // ちょうど16文字
			"B123456789, true", // 範囲内
			"a1234567, false", // 先頭が小文字
			"12345678, false", // 先頭が英字以外
			"A123456, false", // 7文字（短すぎる）
			"A1234567890123456, false" // 17文字（長すぎる）
	})
	void testIsValidPassword(String password, boolean expected) {
		assertEquals(expected, validator.isValidPassword(password), "パスワード [" + password + "] の判定が間違っています");
	}
}
